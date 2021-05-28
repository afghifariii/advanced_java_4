import java.sql.*;


public class ConnectToDatabase {
    public static void main(String[] args) {
        String userName = "digitalskola";
        String password = "digitalskola";
        String connectionString = "jdbc:postgresql://127.0.0.1:5432/etl_db?user="+userName+"&password="+password;

        String createTableQuery = "CREATE TABLE REGISTRATION " +
                "(id INTEGER not NULL, " +
                " first VARCHAR(255), " +
                " last VARCHAR(255), " +
                " age INTEGER, " +
                " PRIMARY KEY ( id ))";

        String insertQuery = "INSERT INTO REGISTRATION VALUES (100, 'Zinedine', 'Zidane', 42), (101, 'Beni', 'Dolo', 50)";
        String updateQuery = "UPDATE REGISTRATION SET age = 51 WHERE id = 101";
        String deleteQuery = "DELETE FROM REGISTRATION WHERE id = 101";
        String selectQuery = "SELECT * FROM REGISTRATION";



        try {
            Connection conn = DriverManager.getConnection(connectionString);
            Statement stmnt = conn.createStatement();

            stmnt.executeUpdate(deleteQuery);

            ResultSet rs = stmnt.executeQuery(selectQuery);

            while (rs.next()) {
                System.out.println("======================================");
                System.out.println("Id: " + rs.getInt("id"));
                System.out.println("First Name: " + rs.getString("first"));
                System.out.println("Last Name: " + rs.getString("last"));
                System.out.println("Age: " + rs.getInt("age"));
            }


            stmnt.close();
            conn.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
}
