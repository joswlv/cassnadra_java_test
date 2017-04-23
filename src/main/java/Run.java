import com.datastax.driver.core.Session;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Jo_seungwan on 2017. 4. 2..
 */
public class Run {

    public static void main(String[] args) throws Exception {
        GetConfig config = new GetConfig();
        CassandraConnector connector = new CassandraConnector();
        Query query = new Query();
        FileInput fileInput = new FileInput();

        HashMap<String, String> cassandraInfo = config.getCassandraInfo();
        connector.connect(cassandraInfo.get("cassandra.contactpoints"),
                cassandraInfo.get("cassandra.keyspace"),
                cassandraInfo.get("cassandra.port"),
                cassandraInfo.get("cassandra.username"),
                cassandraInfo.get("cassandra.password"));
        Session session = connector.getSession();

        ArrayList<InputModel> adidData = new ArrayList<>();
        ArrayList<InputModel> bidData = new ArrayList<>();
        fileInput.getUidData("adid", adidData);
        fileInput.getUidData("bid", bidData);

        for (InputModel adidInfo : adidData) {
            if ( adidInfo.getAgeCode() != -1 ) {
                query.insertUserDemo(session, adidInfo);
            }
            if ( adidInfo.getCategoryCode() != -1 ) {
                query.insertUser_Interest_Category_App(session, adidInfo);
            }
        }

        for (InputModel bidInfo : bidData) {
            if ( bidInfo.getAgeCode() != -1 ) {
                query.insertUserDemo(session, bidInfo);
            }
            if ( bidInfo.getCategoryCode() != -1 ) {
                query.insertUser_Interest_Category(session, bidInfo);
            }
        }
        session.close();
        connector.close();
    }
}
