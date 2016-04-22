package sample;

import java.sql.*;

/**
 * Created by sharang on 4/22/16.
 */
public class Database {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    public Database()
    {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bbms","root","sharang");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insert(String name,String addr,String contact,String bloodgroup,String platelet,String rbc)
    {
        try {
            ps=con.prepareStatement("INSERT INTO donors(name,address,contactno) VALUES (?, ?, ?)");
            ps.setString(1,name);
            ps.setString(2,addr);
            ps.setString(3,contact);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            ps=con.prepareStatement("INSERT INTO blood(bloodgroup,platelet,rbc) VALUES (?, ?, ?)");
            ps.setString(1,bloodgroup);
            ps.setString(2,platelet);
            ps.setString(3,rbc);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet retrieve(String bg)
    {
        try {
            ps = con.prepareStatement("SELECT * from donors INNER JOIN blood USING(id) WHERE bloodgroup = ?");
            ps.setString(1,bg);
            rs=ps.executeQuery();
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}