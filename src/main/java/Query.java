import com.datastax.driver.core.Session;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Jo_seungwan on 2017. 4. 1..
 */
public class Query {

    public static String getTodayStr() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:SS").format(new Date());
    }

    public void insertUserDemo(Session session, InputModel inputModel){
        StringBuilder sb = new StringBuilder("INSERT INTO ")
                .append(TableName.USER_DEMO).append("(uid, date, score, age_code, gender_code, marriage) ")
                .append("VALUES (")
                .append(inputModel.getUid())
                .append(getTodayStr()).append(", '")
                .append(inputModel.getAgeCode()).append(", '")
                .append(inputModel.getGenderCode()).append(", '")
                .append(inputModel.getMarriageCode()).append(", '")
                .append("');");
        String query = sb.toString();
        session.execute(query);
    }

    public void insertUser_Interest_Category(Session session, InputModel inputModel){
        StringBuilder sb = new StringBuilder("INSERT INTO ")
                .append(TableName.USER_INTREST_CATEGORY).append("(uid, date, score, category_id) ")
                .append("VALUES (")
                .append(inputModel.getUid())
                .append(getTodayStr()).append(", '")
                .append(inputModel.getCategoryCode()).append(", '")
                .append("');");
        String query = sb.toString();
        session.execute(query);
    }

    public void insertUser_Interest_Category_App(Session session, InputModel inputModel){
        StringBuilder sb = new StringBuilder("INSERT INTO ")
                .append(TableName.USER_INTREST_CATEGORY_APP).append("(uid, date, score, category_id) ")
                .append("VALUES (")
                .append(inputModel.getUid())
                .append(getTodayStr()).append(", '")
                .append(inputModel.getCategoryCode()).append(", '")
                .append("');");
        String query = sb.toString();
        session.execute(query);
    }
}
