import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.QueryLogger;
import com.datastax.driver.core.Session;

/**
 * Created by Jo_seungwan on 2017. 4. 1..
 */
public class CassandraConnector {
    private Session session;
    private Cluster cluster;


    public void connect(String serverIP, String keyspace, Integer port) {

        Cluster.Builder b = Cluster.builder()
                .addContactPoints(serverIP);
        if (port != null) {
            b.withPort(port);
        }
        Cluster cluster = b.build();

        QueryLogger queryLogger = QueryLogger.builder(cluster).withConstantThreshold(300).build();
        cluster.register(queryLogger);
        this.session = cluster.connect(keyspace);
    }

    public Session getSession() {
        return this.session;
    }

    public void close() {
        session.close();
        cluster.close();
    }
}
