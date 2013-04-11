import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SqlServerJDBCDemo{
    public static void main(String[] args){
    	try {
            Class.forName( "com.microsoft.sqlserver.jdbc.SQLServerDriver" );
            System.out.println("Driver Loaded");
            
            String server = "SERVER1";
            int port = 1433;
            String user = "dwhf";
            String password = "dwhf";            
            String database = "KPI_DWH";
            
            String jdbcUrl = "jdbc:sqlserver://"+server+":"+port+";user="+user+";password="+password+";databaseName="+database+"";

            Connection con = DriverManager.getConnection(jdbcUrl);
            System.out.println("Connection erstellt");
            
            Statement stmt = con.createStatement();
            System.out.println("Statement erstellt");    
            
            ResultSet rs = stmt.executeQuery("SELECT COUNT(*) FROM DWHF.D_DATUM;");
            System.out.println("Query erstellt");    
            
            if(rs.next()) {
            	System.out.println("Datum Count :" +rs.getInt(1));
            }

            rs.close();
            stmt.close();
            con.close();
            System.out.println("Resourcen released");
        } catch (Exception ex) {
        	System.out.println("Error :" +ex);
        }
}
};