import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertDataMysql extends MysqlConnection {

    public static void InsertData(String name, String position, int salary) {
        String sql = "INSERT INTO employees (employee_name, position, salary) VALUES (?, ?, ?)";
        Connection connection = null;
        try
        {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,position);
            preparedStatement.setInt(3,salary);

            preparedStatement.executeUpdate();


        }catch (SQLException e){
            System.out.println("Satır eklenirken bir hata oluştu: "+e.getMessage());
        }
        try {
            connection.close();
        } catch (SQLException e) {
            System.err.println("Bağlantı kapatma hatası: " + e.getMessage());
        }

    }
}
