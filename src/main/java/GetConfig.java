import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;

/**
 * cassandra-java-test - 2017. 4. 3..
 */
public class GetConfig {

    public HashMap<String,String> getCassandraInfo() throws IOException {
        HashMap<String,String> cassandraInfo = new HashMap<>();

        InputStream inputStream = null;

        try {
            Properties prop = new Properties();
            String propFileName = "config.properties";

            inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

            if (inputStream != null){
                prop.load(inputStream);
            } else{
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }

            cassandraInfo.put("cassandra.contactpoints", prop.getProperty("cassandra.contactpoints"));
            cassandraInfo.put("cassandra.port", prop.getProperty("cassandra.port"));
            cassandraInfo.put("cassandra.keyspace", prop.getProperty("cassandra.keyspace"));
            cassandraInfo.put("cassandra.username", prop.getProperty("cassandra.username"));
            cassandraInfo.put("cassandra.password", prop.getProperty("cassandra.password"));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            inputStream.close();
        }

        return cassandraInfo;
    }
}
