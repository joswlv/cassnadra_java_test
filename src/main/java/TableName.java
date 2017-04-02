/**
 * Created by Jo_seungwan on 2017. 4. 2..
 */
public enum TableName {

    USER_DEMO("user_demo"),
    USER_INTREST_CATEGORY("user_interest_category"),
    USER_INTREST_CATEGORY_APP("user_interest_category_app");

    String tableName;

    TableName(String tableName){
        this.tableName = tableName;
    }
    public String toString(){
        return this.tableName;
    }
}
