package querytype;

import com.gs.collections.impl.list.mutable.FastList;
import database.dao.DAO;
import database.entity.Degree;
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
 * Created by Shanshan Jiang on 4/23/2016.
 */
public class DegreeQuery {
    private static DAO dao;

    public DegreeQuery(DAO dao) {
        DegreeQuery.dao = dao;
    }

    private static List<GraphQLArgument> argumentList = FastList.newListWith(
            newArgument().name("id").description("id of the degree").type(new GraphQLList(GraphQLInt)).build(),
            newArgument().name("object_id").description("object_id of the person").type(new GraphQLList(GraphQLString)).build(),
            newArgument().name("degree_type").type(GraphQLString).build(),
            newArgument().name("subject").type(GraphQLString).build(),
            newArgument().name("institution").type(GraphQLString).build(),
            newArgument().name("graduated_at").type(GraphQLString).build()
    );

    public static GraphQLObjectType degreeType = newObject()
            .name("Degree")
            .description("Information related to degree")
            .field(newFieldDefinition().name("id").type(GraphQLInt).build())
            .field(newFieldDefinition().name("object_id").type(GraphQLString).build())
            .field(newFieldDefinition().name("degree_type").type(GraphQLString).build())
            .field(newFieldDefinition().name("subject").type(GraphQLString).build())
            .field(newFieldDefinition().name("institution").type(GraphQLString).build())
            .field(newFieldDefinition().name("graduated_at").type(GraphQLString).build()) // Should be a time_stamp type, is there any?
            .field(newFieldDefinition().name("created_at").type(GraphQLString).build())
            .field(newFieldDefinition().name("updated_at").type(GraphQLString).build())
            .build();

    static DataFetcher fetchDegreeData = new DataFetcher() {
        public Object get(DataFetchingEnvironment environment) {
            List<Degree> degrees = new LinkedList<>();
            if (environment.getSource() != null) {
                Person person = (Person) environment.getSource();
                String id = person.getObject_id();
                degrees.addAll(dao.findByStringValues(Degree.class, "object_id", FastList.newListWith(id)));
            }
            return degrees;
        }
    };

    public static GraphQLObjectType degreeQueryType = newObject()
            .name("QueryType")
            .field(newFieldDefinition()
                    .name("degree")
                    .type(new GraphQLList(degreeType))
                    .argument(argumentList)
                    .dataFetcher(fetchDegreeData)
                    .build())
            .build();

}
