import java.sql.*;

public class MysqlConnection {

    public static final String DB_URL = "jdbc:mysql://localhost/btcompany";
    public static final String DB_USER = "root";
    public static final String DB_PASSWORD = "mysql";
    static String prpSql = "SELECT * FROM employees";
    static void mysqlConnect()
    {
        try {
            Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            PreparedStatement preparedStatement = con.prepareStatement(prpSql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                System.out.println("Employee Name: " + resultSet.getString("employee_name"));
                System.out.println("Employee Position: " + resultSet.getString("position"));
                System.out.println("Employee Salary: " + resultSet.getString("salary"));
                System.out.println("************************************");
            }
            resultSet.close();
            preparedStatement.close();
            con.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
