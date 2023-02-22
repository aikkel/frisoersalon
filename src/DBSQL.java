import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

public class DBSQL {

    private Connection connection;
    private Statement stmt;

    DBSQL() {
        connection = null;
        stmt = null;
        try {
            String url = "jdbc:sqlite:C://Users/aikke/IdeaProjects/TrackAndTrace/TrackAndTraceDB.db";
            connection = DriverManager.getConnection(url);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    //TODO Omhandler Users

    //Adds en user til databasen
    public void addUser(User u) {
        try {
            String sql = "INSERT INTO User (fNavn,eNavn,adresse,postNr,telefonNr,eMail,password) VALUES('"
                    + String.valueOf(u.getfNavn()) + "','" + u.geteNavn() + "','";
            sql = sql + u.getAdresse() + "','" + u.getPostNr() + "','" + u.getTelefonNr() + "','" + u.geteMail() + "')";

            Statement stmt = connection.createStatement();
            stmt.execute(sql);

            System.out.println("Connection to SQLite has been established. \n");
            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    //find user ud fra user_id og opretter instans af user med attributes læst fra sql database
    public User getUser(int id) {
        try{
            String sql = "SELECT * FROM User WHERE user_id = " + id + ";";

            Statement stmt = connection.createStatement();
            stmt.execute(sql);
            ResultSet rs = stmt.getResultSet();
            return new User(
                    rs.getInt("userId"),
                    rs.getString("fNavn"),
                    rs.getString("eNavn"),
                    rs.getString("addresse"),
                    rs.getInt("postNr"),
                    rs.getInt("telefonNr"),
                    rs.getString("email"),
                    rs.getString("password"),
                    rs.getBoolean("medarbejder"));
        } catch (SQLException throwables){
            throwables.printStackTrace();
            System.out.println("Invalid User ID");
        } return null;
    }

    public ArrayList<User>  getAllUsers() {
        try {
            String sql = "SELECT * FROM User ";
            Statement stmt = connection.createStatement();
            stmt.execute(sql);
            ResultSet rs = stmt.getResultSet();
            ArrayList<User> userListe = new ArrayList<>();
            while (rs.next()) {
                {
                    User u = new User(
                            rs.getInt("userId"),
                            rs.getString("fNavn"),
                            rs.getString("eNavn"),
                            rs.getString("adresse"),
                            rs.getInt("postNr"),
                            rs.getInt("telefonNr"),
                            rs.getString("eMail"),
                            rs.getString("Password"),
                            rs.getBoolean("medarbejder"));
                    userListe.add(u);
                }
            }
            return userListe;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


//TODO Omhandler bestillinger

    public void addBestilling(Bestilling b) {
        try {
            String sql = "INSERT INTO Bestilling (dato,klokkeslæt,behandlingsType,behandlingsTid,pris,status,bestillingID) VALUES('"
                    + String.valueOf(b.getDato()) + "','" + b.getKlokkeslæt() + "','";
            sql = sql + b.getBehandlingsType() + "','" + b.getBehandlingsTid() + "','" + b.getPris() + "','" + b.getStatus() + "','" + b.getBestillingID() + "')";

            Statement stmt = connection.createStatement();
            stmt.execute(sql);

            System.out.println("Connection to SQLite has been established. \n");
            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    //find bestilling ud fra bestillingid og opretter instans af bestilling med attributes læst fra sql database
    public Bestilling getBestilling(int id) {
        try{
            String sql = "SELECT * FROM Bestilling WHERE bestilling_id = " + id + ";";

            Statement stmt = connection.createStatement();
            stmt.execute(sql);
            ResultSet rs = stmt.getResultSet();
            return new Bestilling(
                    rs.getInt("bestillingId"),
                    rs.getDate("dato"),
                    rs.getString("klokkeslæt"),
                    rs.getString("behandlingstype"),
                    rs.getDouble("behandlingstid"),
                    rs.getDouble("pris"),
                    rs.getInt("kunde"),
                    rs.getInt("medarbejder"),
                    rs.getString("status"));
        } catch (SQLException throwables){
            throwables.printStackTrace();
            System.out.println("Invalid Order ID");
        } return null;
    }

    //Henter alle bestillinger
    public ArrayList<Bestilling>  getAllBestilling() {
        try {
            String sql = "SELECT * FROM Bestilling ";
            Statement stmt = connection.createStatement();
            stmt.execute(sql);
            ResultSet rs = stmt.getResultSet();
            ArrayList<Bestilling> bestillingListe = new ArrayList<>();
            while (rs.next()) {
                {
                    Bestilling b = new Bestilling(
                            rs.getInt("bestillingID"),
                            rs.getDate("dato"),
                            rs.getString("klokkeslæt"),
                            rs.getString("behandlingsType"),
                            rs.getDouble("behandlingsTid"),
                            rs.getDouble("pris"),
                            rs.getInt("kunde"),
                            rs.getInt("medarbejder"),
                            rs.getString("status"));
                    bestillingListe.add(b);
                }
            }
            return bestillingListe;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }




    /*
import java.util.Scanner;

public class DBSql {

    private Connection connection;
    private Statement stmt;

    public Connection connectToDatabase() {
        Connection connection = null;
        String stmt = null;

        try {

            String url = "jdbc:sqlite:C://Users/aikke/IdeaProjects/SpilProjektv2/WarlockOfFiretopMountain.db";
            connection = DriverManager.getConnection(url);


            return connection;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }*/
}
