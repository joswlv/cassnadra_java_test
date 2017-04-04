import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.querybuilder.Insert;
import com.datastax.driver.core.querybuilder.QueryBuilder;

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

    public void insertUserDemo(Session session, InputModel inputModel){
        Insert insert = QueryBuilder.insertInto("user_demo")
                .value("uid",inputModel.getUid())
                .value("date", getTodayStr())
                .value("score", 3.5)
                .value("age_code", inputModel.getAgeCode())
                .value("gender_code", inputModel.getGenderCode())
                .value("marriage", inputModel.getMarriageCode());

        System.out.println(insert.toString());
        ResultSet result = session.execute(insert.toString());
        System.out.println(result);
    }

    public void insertUser_Interest_Category(Session session, InputModel inputModel){
        Insert insert = QueryBuilder.insertInto("user_interest_category")
                .value("uid", inputModel.getUid())
                .value("date", getTodayStr())
                .value("score", 1)
                .value("category_id", inputModel.getCategoryCode());

        System.out.println(insert.toString());
        ResultSet result = session.execute(insert.toString());
        System.out.println(result);
    }

    public void insertUser_Interest_Category_App(Session session, InputModel inputModel){
        Insert insert = QueryBuilder.insertInto("user_interest_category_app")
                .value("uid", inputModel.getUid())
                .value("date", getTodayStr())
                .value("score", 1)
                .value("category_id", inputModel.getCategoryCode());

        System.out.println(insert.toString());
        ResultSet result = session.execute(insert.toString());
        System.out.println(result);
    }
}
