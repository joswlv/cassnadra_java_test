import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * cassandra-java-test - 2017. 4. 3..
 */
public class TestCode{
    public static void main(String[] args) throws Exception {
        FileInput fileInput = new FileInput();
        GetConfig config = new GetConfig();
        CassandraConnector connector = new CassandraConnector();
        HashMap<String, String> cassandraInfo = config.getCassandraInfo();
        connector.connect(cassandraInfo.get("cassandra.contactpoints"),
                cassandraInfo.get("cassandra.keyspace"),
                cassandraInfo.get("cassandra.port"),
                cassandraInfo.get("cassandra.username"),
                cassandraInfo.get("cassandra.password"));
        Session session = connector.getSession();

        ResultSet result = session.execute("SELECT * FROM user_demo limit 10;");
        List<InputModel> cln = new ArrayList<>();

        result.forEach(r -> {
            InputModel inputModel = new InputModel();
            inputModel.setUid(r.getString(0));
            cln.add(inputModel);
        });

        for (Iterator<InputModel> iterator = cln.iterator(); iterator.hasNext(); ) {
            InputModel next =  iterator.next();

            System.out.println(next.getUid());

        }

//        ArrayList<InputModel> data = fileInput.getUidData("adid");
//
//        for (InputModel info:data) {
//            System.out.println(info.getUid() +", "+info.getCategoryCode());
//        }
    }
}
