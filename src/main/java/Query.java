import com.datastax.driver.core.Session;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Jo_seungwan on 2017. 4. 1..
 */
public class Query {

    public static String getTodayStr() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }
    final static Timestamp nowtime = new Timestamp(new Date().getTime());
    public void insertUserDemo(Session session, InputModel inputModel){
        final String query = "INSERT INTO user_demo (uid, date, score, age_code, gender_code, marriage) VALUES (?,?,?,?,?,?)";
        session.execute(query,
                inputModel.getUid(),
                getTodayStr(),
                3.5,
                inputModel.getAgeCode(),
                inputModel.getGenderCode(),
                inputModel.getMarriageCode());
    }

    public void insertUser_Interest_Category(Session session, InputModel inputModel){
        final String query = "INSERT INTO user_interest_category (uid, date, score, category_id) VALUES (?,?,?,?)";
        session.execute(query,
                inputModel.getUid(),
                getTodayStr(),
                1,
                inputModel.getCategoryCode());
    }

    public void insertUser_Interest_Category_App(Session session, InputModel inputModel){
        final String query = "INSERT INTO user_interest_category_app (uid, date, score, category_id) VALUES (?,?,?,?)";
        session.execute(query,
                inputModel.getUid(),
                getTodayStr(),
                1,
                inputModel.getCategoryCode());
    }
}
