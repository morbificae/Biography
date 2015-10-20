import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Iterator;
import java.util.List;

public class dbIO {

  public void createDB(){
    Connection c = null;
    Statement stmt = null;
    try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:test.db");
      System.out.println("Opened database successfully");

      stmt = c.createStatement();

      String sql = "CREATE TABLE RUS_MALE_NAMES " +
          "(ID       INTEGER PRIMARY KEY AUTOINCREMENT," +
          "RUS_MALE     TEXT)";
      stmt.executeUpdate(sql);

      String sql2 = "CREATE TABLE RUS_FEMALE_NAMES " +
          "(ID       INTEGER PRIMARY KEY AUTOINCREMENT," +
          "RUS_FEMALE   TEXT)";
      stmt.executeUpdate(sql2);

      String sql3 = "CREATE TABLE RUS_SURNAMES " +
          "(ID       INTEGER PRIMARY KEY AUTOINCREMENT," +
          "SURNAME   TEXT)";
      stmt.executeUpdate(sql3);

      stmt.close();
      c.close();
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      System.exit(0);
    }
    System.out.println("Table created successfully");
  }
  public void fillDB (List<String> male, List<String> female, List<String> surname){
    Connection c = null;
    Statement stmt = null;
    try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:test.db");
      c.setAutoCommit(false);
      System.out.println("Opened database successfully");
      stmt = c.createStatement();

      for (String s : male) {
        String sql = "INSERT INTO RUS_MALE_NAMES (RUS_MALE) VALUES ('" + s + "');";
        stmt.executeUpdate(sql);
      }
      System.out.println("муж ок");


      for (String s : female) {
        String sql = "INSERT INTO RUS_FEMALE_NAMES (RUS_FEMALE) VALUES ('" + s + "');";
        stmt.executeUpdate(sql);
      }
      System.out.println("баб ок");

      for (String s : surname) {
        String sql = "INSERT INTO RUS_SURNAMES (SURNAME) VALUES ('" + s + "');";
        stmt.executeUpdate(sql);
      }
      System.out.println("фам ок");


      stmt.close();
      c.commit();
      c.close();
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      System.exit(0);
    }
    System.out.println("Records created successfully");
  }
  public void testDBConnection(){
    Connection c = null;
    try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:test.db");
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      System.exit(0);
    }
    System.out.println("Opened database successfully");
  }
}
