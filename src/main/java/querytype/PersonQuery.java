package querytype;

import com.gs.collections.impl.list.mutable.FastList;
import database.dao.PersonDAO;
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

    private static PersonDAO personDAO;

    public PersonQuery (PersonDAO personDAO) {
        PersonQuery.personDAO = personDAO;
    }

    private static List<GraphQLArgument> argumentList = FastList.newListWith(
            newArgument().name("id").description("id of the person").type(GraphQLInt).build(),
            newArgument().name("object_id").description("object_id of the person").type(GraphQLString).build(),
            newArgument().name("first_name").type(GraphQLString).build(),
            newArgument().name("last_name").type(GraphQLString).build(),
            newArgument().name("birthplace").type(GraphQLString).build(),
            newArgument().name("affiliation_name").type(GraphQLString).build()
    );

    private static DataFetcher fetchPersonData = new DataFetcher() {
        public Object get(DataFetchingEnvironment environment) {
            //FIXME: just for testing purpose
            List<Person> people = new LinkedList<Person>();
            if(environment.getArguments().get("object_id") != null) {
                // do some find here
            } else if(environment.getArguments().get("id") != null) {
                int id = (Integer) environment.getArguments().get("id");
                people.add(personDAO.findById(id).get());
            } else {
                people.addAll(personDAO.findTop10());
            }
            return people;
        }
    };

    private static GraphQLObjectType personType = newObject()
            .name("Person")
            .description("Information related to a person")
            .field(newFieldDefinition().name("id").type(GraphQLInt).build())
            .field(newFieldDefinition().name("object_id").type(GraphQLString).build())
            .field(newFieldDefinition().name("first_name").type(GraphQLString).build())
            .field(newFieldDefinition().name("last_name").type(GraphQLString).build())
            .field(newFieldDefinition().name("birthplace").type(GraphQLString).build())
            .field(newFieldDefinition().name("affiliation_name").type(GraphQLString).build())
            .build();

    public static GraphQLObjectType queryType = newObject()
            .name("QueryType")
            .field(newFieldDefinition()
                    .name("person")
                    .type(new GraphQLList(personType))
                    .argument(argumentList)
                    .dataFetcher(fetchPersonData)
                    .build())
            .build();
}
