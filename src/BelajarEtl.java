import java.sql.*;
import java.io.*;

public class BelajarEtl {
    public static void main(String[] args) {
        String userName = "digitalskola";
        String password = "digitalskola";
        String connectionString = "jdbc:postgresql://127.0.0.1:5432/etl_db?user="+userName+"&password="+password;

        try {
            String selectQuery = "SELECT * FROM REGISTRATION";

            Connection conn = DriverManager.getConnection(connectionString);
            Statement stmnt = conn.createStatement();

            FileReader file = new FileReader("/Users/afghifari/Workspace/digitalskola/advanced_java_4/data.csv");
            BufferedReader reader = new BufferedReader(file);
            String lineText = null;

            // skip header
            reader.readLine();

            //1,ali,ghifari,27
            while ((lineText = reader.readLine()) != null) {
                String[] data = lineText.split(",");
                int id = Integer.parseInt(data[0]);
                String first = data[1];
                String last = data[2];
                int age = Integer.parseInt(data[3]);

                String query = "INSERT INTO REGISTRATION VALUES ("+id+", '"+first+"', '"+last+"', "+age+")";

                stmnt.executeUpdate(query);

            }

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

        } catch(SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}
