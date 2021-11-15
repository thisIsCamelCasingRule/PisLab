import database.Database;
import database.UserQueries;

import java.sql.Connection;
import java.sql.SQLException;


public class Fattracker {
    public static void main(String[] args){

        try {
            // Get db connection
            Database db = new Database();
            // Connection conn = Database.getConnection();
            UserQueries q = new UserQueries();

            boolean result = db.executeStatement(q.getGetAllUsers());
            System.out.println(result);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
