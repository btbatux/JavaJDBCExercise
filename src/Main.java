import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {


    public static void main(String[] args) {


        // Yeni bir çalışan ekleyelim
        InsertDataMysql.InsertData("Salih Karatas", "Cyber Security", 13455);

        //DB bağlantısını başlat
        MysqlConnection.mysqlConnect();


    }
}