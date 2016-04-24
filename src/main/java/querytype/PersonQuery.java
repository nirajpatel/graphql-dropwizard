package querytype;

import com.gs.collections.impl.list.mutable.FastList;
import database.dao.DAO;
import database.entity.Person;
import graphql.schema.*;

import java.util.LinkedList;
import java.util.List;

import static graphql.Scalars.GraphQLInt;
import static graphql.Scalars.GraphQLString;
import static graphql.schema.GraphQLArgument.newArgument;
import static graphql.schema.GraphQLFieldDefinition.newFieldDefinition;
import static graphql.schema.GraphQLObjectType.newObject;

/**
 * Created by Shanshan Jiang on 4/10/2016.
 */
public class PersonQuery {

    private static DAO dao;

    public PersonQuery(DAO dao) {
        PersonQuery.dao = dao;
    }

    static List<GraphQLArgument> argumentList = FastList.newListWith(
            newArgument().name("id").description("id of the person").type(new GraphQLList(GraphQLInt)).build(),
            newArgument().name("object_id").description("object_id of the person").type(new GraphQLList(GraphQLString)).build(),
            newArgument().name("first_name").type(GraphQLString).build(),
            newArgument().name("last_name").type(GraphQLString).build(),
            newArgument().name("birthplace").type(GraphQLString).build(),
            newArgument().name("affiliation_name").type(GraphQLString).build()
    );

    static DataFetcher fetchPersonData = new DataFetcher() {
        public Object get(DataFetchingEnvironment environment) {
            //TODO: What if these 2 ids come at the same time in schema?
            List<Person> people = new LinkedList<>();
            if (environment.getArguments().get("object_id") != null) {
                Object ids = environment.getArguments().get("object_id");
                if (ids instanceof List) {
                    people.addAll(dao.findByStringValues(Person.class, "object_id", (List<String>) ids));
                }
            } else if (environment.getArguments().get("id") != null) {
                Object ids = environment.getArguments().get("id");
                if (ids instanceof List) {
                    people.addAll(dao.findByIntegerValues(Person.class, "id", (List<Integer>) ids));
                }
            } else {
                people.addAll(dao.findTopRecords(Person.class, 10));
            }
            return people;
        }
    };

    static GraphQLObjectType personType = newObject()
            .name("Person")
            .description("Information related to a person")
            .field(newFieldDefinition().name("id").type(GraphQLInt).build())
            .field(newFieldDefinition().name("object_id").type(GraphQLString).build())
            .field(newFieldDefinition().name("first_name").type(GraphQLString).build())
            .field(newFieldDefinition().name("last_name").type(GraphQLString).build())
            .field(newFieldDefinition().name("birthplace").type(GraphQLString).build())
            .field(newFieldDefinition().name("affiliation_name").type(GraphQLString).build())
            .field(newFieldDefinition()
                    .name("degree")
                    .description("The degree of the person, or an empty list if no record found.")
                    .type(new GraphQLList(DegreeQuery.degreeType))
                    .dataFetcher(DegreeQuery.fetchDegreeData)
                    .build())
            .build();
}
