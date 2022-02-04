/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.UUID;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.patientStore;
import model.Patient;
/**
 *
 * @author ABHI
 */
public class jdbcConnection {
    public Connection hugeconnect = null;
    public ResultSet largeset = null;
    patientStore patientDB;
    public jdbcConnection()
    { this.patientDB = patientDB;
    }
    
    private javax.swing.JSplitPane jSplitPane1;

    // Variables declaration - do not modify                     
    private javax.swing.JLabel AgejLabel;
    private javax.swing.JLabel AgejLabel1;
    private javax.swing.JLabel DiastolicjLabel;
    private javax.swing.JTextField DiastolicjTextField;
    private javax.swing.JLabel InsuranceNumberjLabel;
    private javax.swing.JTextField NamejTextField;
    private javax.swing.JTextField NamejTextField1;
    private javax.swing.JTextField SexjTextField;
    private javax.swing.JTextField SexjTextField1;
    private javax.swing.JLabel SystolicjLabel2;
    private javax.swing.JTextField SystolicjTextField;
    private javax.swing.JButton addNewPatientjButton;
    private javax.swing.JButton addPatientjButton;
    private javax.swing.JPanel addPatientjPanel;
    private javax.swing.JButton addjButton;
    private javax.swing.JTextField agejTextField;
    private javax.swing.JTextField agejTextField1;
    private javax.swing.JLabel apartmentNumberjLabel;
    private javax.swing.JLabel apartmentNumberjLabel1;
    private javax.swing.JTextField apartmentNumberjTextField;
    private javax.swing.JTextField apartmentNumberjTextField1;
    private javax.swing.JLabel cityJLabel;
    private javax.swing.JLabel cityJLabel1;
    private javax.swing.JTextField cityjTextField;
    private javax.swing.JTextField cityjTextField1;
    private javax.swing.JLabel communityJLabel;
    private javax.swing.JLabel communityJLabel1;
    private javax.swing.JTextField communityjTextField;
    private javax.swing.JTextField communityjTextField1;
    private javax.swing.JLabel enterDiastolicjLabel1;
    private javax.swing.JLabel enterSystolicjLabel;
    private javax.swing.JTextField insuranceNumberjTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField newDiastolicjTextField1;
    private javax.swing.JTextField newSystolicjTextField;
    private javax.swing.JLabel patientNamejLabel;
    private javax.swing.JLabel patientNamejLabel1;
    private javax.swing.JButton searchjButton;
    private javax.swing.JTextField searchjTextField;
    private javax.swing.JLabel sexjLabel;
    private javax.swing.JLabel sexjLabel1;
    
    public Connection connect() {
        Connection conn = null;
        try {
            // db parameters
            String url = "jdbc:sqlite:C:/Users/ABHI/Documents/NetBeansProjects/Assignment4/healthcareDB.db";
           // String sql ="SELECT * FROM data";
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            Statement stmt  = conn.createStatement();
            
//            ResultSet rs    = stmt.executeQuery(sql);
//            System.out.println("Connection to SQLite has been established.");
//            while(rs.next())
//            {   System.out.println(rs.getString("UniqueNumber"));
//            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
//        } finally {
//            try {
//                if (conn != null) {
//                    conn.close();
//                }
//            } catch (SQLException ex) {
//                System.out.println(ex.getMessage());
//            }
//        }
        return conn;
    }
    public void updateFn(Connection conn,String city)
    {    try 
    {
        String updateStatement = "UPDATE data SET CITY =?" +"WHERE UniqueNumber=?";
            PreparedStatement pstmt = conn.prepareStatement(updateStatement);
            pstmt.setString(1,city);
            pstmt.setString(2,"4T1BF1FK9GU260157");
            pstmt.executeUpdate();
    }
    catch (SQLException e)
    { System.out.println(e.getMessage());
    }
    finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
    public ResultSet displaypersonInformation(Connection con)
    {   ResultSet rs = null;
       try
       {
        String sql ="SELECT * FROM persontbl";
        Statement stmt  = con.createStatement();
     
            rs    = stmt.executeQuery(sql);
            System.out.println("Connection to SQLite has been established.");
            
//            while(rs.next())
//            {   System.out.println(rs.getString("InsuranceNumber"));
//            }
       //closeConnection(con);
       }
       catch(SQLException e)
       {
           System.out.println(e.toString());
       }
      
       return rs;
    }
    
    public String createPerson(Connection conn,String name,int age,String sex,String apartmentNumber,String community, String city)
    {   String insuranceNo=null;
        try
    {   UUID uuid = UUID.randomUUID();
    System.out.println(uuid);
        insuranceNo=uuid.toString(); 
        String sql = "INSERT INTO persontbl(InsuranceNumber,Name,Age,Sex,ApartmentNumber,Community,City) VALUES(?,?,?,?,?,?,?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1,insuranceNo);
        pstmt.setString(2,name);
        pstmt.setInt(3,age);
        pstmt.setString(4,sex);
        pstmt.setString(5,apartmentNumber);
        pstmt.setString(6,community);
        pstmt.setString(7,city);
        pstmt.executeUpdate();
        closeConnection(conn);
    }
    catch (SQLException e)
    { System.out.println(e.getMessage());
    }
        return insuranceNo;
    }
    
    public ResultSet searchPatient(String InsuranceNumber)
    {      String Val = null;
           ResultSet rs = null;
        Connection conn = null;
        try {
            // db parameters
            String url = "jdbc:sqlite:C:/Users/ABHI/Documents/NetBeansProjects/Assignment4/healthcareDB.db";
              conn = DriverManager.getConnection(url);
              Statement stmt  = conn.createStatement();
              
              //String viewStatement = "SELECT persontbl.Name,patientdata.SystolicPressure,patientdata.DiastolicPressure,persontbl.InsuranceNumber,persontbl.Age,persontbl.Sex,persontbl.ApartmentNumber,persontbl.Community,persontbl.City FROM persontbl INNER JOIN patientdata on ? = persontbl.InsuranceNumber;";
               String viewStatement = " select a.Name,b.SystolicPressure,b.DiastolicPressure,a.InsuranceNumber,a.Age,a.Sex,a.ApartmentNumber,a.Community,a.City\n" +
" from persontbl a,patientdata b WHERE a.InsuranceNumber = b.InsuranceNumber and a.InsuranceNumber= ?"; 
//String viewStatement = "SELECT * FROM patientdata where InsuranceNumber=?";
              PreparedStatement pstmt  = conn.prepareStatement(viewStatement);
              pstmt.setString(1, InsuranceNumber);
              rs    = pstmt.executeQuery();
              //closeConnection(conn);
              
              
//              while(rs.next()!=false)
//              { Val = "hell";
//                  System.out.println(rs.getString("InsuranceNumber"));
//              System.out.println("2!!@#######@@@!!$%^^%!!!!!@@@@@@");
//              }
        }
        catch(Exception e)
        { System.out.println(e);
        }
            return rs;
    }
    
    public ResultSet displayPatient()
    {   ResultSet rs= null;
    Connection con = connect();
        try {
        
        //Statement stmt = con.createStatement();
        String viewStatement = "SELECT persontbl.InsuranceNumber,persontbl.Name,persontbl.Sex,persontbl.Age,patientdata.SystolicPressure,patientdata.DiastolicPressure,persontbl.Community,persontbl.City FROM persontbl INNER JOIN patientdata on patientdata.InsuranceNumber = persontbl.InsuranceNumber;";
        PreparedStatement pstmt = con.prepareStatement(viewStatement);
        rs = pstmt.executeQuery();
//        if(rs.next() !=false)
//        {
//            //System.out.println(rs.getString("InsuranceNumber"));
//            System.out.println("!@##############$$");
//        }
        //closeConnection(con);
        //return rs;
        } catch (SQLException ex) {
            Logger.getLogger(jdbcConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        //closeConnection(con);
        return rs;
    }
    
    public void closeConnection(Connection con)
    { if(con != null)
    {   try {
        con.close();
        } catch (SQLException ex) {
            Logger.getLogger(jdbcConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    }
    public void updateVitalCount(String insuranceNumber,String systolicPressure, String diastolicPressure)
    {   try {
        Connection con = connect();
        String updateStatement = "UPDATE patientdata SET SystolicPressure =?, DiastolicPressure=? WHERE InsuranceNumber=?";
        PreparedStatement pstmt = con.prepareStatement(updateStatement);
        pstmt.setString(1,systolicPressure);
        pstmt.setString(2,diastolicPressure);
        pstmt.setString(3,insuranceNumber);
        //pstmt.setString(2,"4T1BF1FK9GU260157");
        pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(jdbcConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    

    /**
     * @param args the command line arguments
     */
//    public static void main(String[] args) {
//        // TODO code application logic here
//        Connection con =connect();
//        updateFn(con);
//    }
//    

  public String[] onePersonDetail(String insuranceNumber)  
  {   ResultSet rs = null;
       String[] arr = new String[7]; 
      Connection con = connect();
      try {
      
      System.out.println(insuranceNumber);
      String viewStatement = "SELECT * FROM persontbl WHERE InsuranceNumber=?";
      
      PreparedStatement pstmt = con.prepareStatement(viewStatement);
      pstmt.setString(1, insuranceNumber);
      rs = pstmt.executeQuery();
     // System.out.println(rs.getString("Name"));
      
      while(rs.next())
      {
         arr[0] = rs.getString("InsuranceNumber");
         arr[1] = rs.getString("Name");
         arr[2] = rs.getString("Age");
         arr[3] = rs.getString("Sex");
         arr[4] = rs.getString("ApartmentNumber");
         arr[5] = rs.getString("Community");
         arr[6] = rs.getString("City");
      }
        } catch (SQLException ex) {
            Logger.getLogger(jdbcConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(jdbcConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
  return arr;
  }
  public String createPatient(String insuranceNumber, String systolicPressure,String diastolicPressure)
  {   String message=null;
      //System.out.println(insuranceNumber);
      try {
      
      Connection con = connect();
      String viewStatement = "SELECT * FROM patientdata WHERE InsuranceNumber=?";
      PreparedStatement pstmt = con.prepareStatement(viewStatement);
      pstmt.setString(1, insuranceNumber);
      ResultSet resset = pstmt.executeQuery();
      System.out.println(resset.isClosed());
      con.close();
      //System.out.println(resset.wasNull());
      //String val =resset.getString("InsuranceNumber");
      if(resset.isClosed()==true)
      { String insertStatement = "INSERT INTO patientdata(InsuranceNumber,SystolicPressure,DiastolicPressure)VALUES(?,?,?)";
       Connection con1 = connect();
      PreparedStatement pstmt1 = con1.prepareStatement(insertStatement);
      pstmt1.setString(1, insuranceNumber);
      pstmt1.setString(2, systolicPressure);
      pstmt1.setString(3, diastolicPressure);
      pstmt1.executeUpdate();
      message="The patient has been successfully added to the patient Directory";
      }
      else
      { message = "The patient already exists in Patient Directory";
      }
      } catch (SQLException ex) {
            Logger.getLogger(jdbcConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
  return message;
  }
  
  public ArrayList<String> neighborhooddropdown()
  {   ArrayList<String> community = new ArrayList<String>();
      try {
      Connection con = connect();
      String viewStatement = "SELECT DISTINCT Community from persontbl";
      PreparedStatement pstmt2 = con.prepareStatement(viewStatement);
      ResultSet neighborhoodRs = pstmt2.executeQuery();
      while(neighborhoodRs.next())
      { community.add(neighborhoodRs.getString(1));
       //System.out.println(neighborhoodRs.getString(1));
      }
      closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(jdbcConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    return community;
  }
  
  
  public ResultSet communitySearch(String community,Connection con)
  {   
    // patientDB = this.patientDB;
    //int a=0;
        //Patient[] Patients = null;
      ResultSet neighborhoodRs = null;
      try {
     // con = connect();
      String viewStatement = "SELECT persontbl.InsuranceNumber,persontbl.Name,persontbl.ApartmentNumber,persontbl.Sex,persontbl.Age,patientdata.SystolicPressure,patientdata.DiastolicPressure,persontbl.Community,persontbl.City FROM persontbl INNER JOIN patientdata on patientdata.InsuranceNumber = persontbl.InsuranceNumber WHERE community=?";
      PreparedStatement pstmt2 = con.prepareStatement(viewStatement);
      pstmt2.setString(1, community);
      neighborhoodRs = pstmt2.executeQuery();
//      while(neighborhoodRs.next())
//      {     int j=0;
//          String []val = neighborhoodRs.getString("SystolicPressure").split(",");
//          for(int i=0;i<val.length;i++)
//          { if(Integer.parseInt(val[i])>120)
//          {  //System.out.println(val[i]);
//              j++;
//          }
//          }
//          if(j>0)
//          { //carInfo carInformation = carDB.addcar();
//          
//              Patient newpatient = patientDB.addPatient();
//          
//            newpatient.setAge(Integer.parseInt(neighborhoodRs.getString("Age")));
//            System.out.println(neighborhoodRs.getString("ApartmentNumber"));
//            newpatient.setApartmentNumber(neighborhoodRs.getString("ApartmentNumber"));
//            newpatient.setCity(neighborhoodRs.getString("City"));
//            newpatient.setCommunity(neighborhoodRs.getString("Community"));
//            newpatient.setDiastolicPressure(neighborhoodRs.getString("DiastolicPressure"));
//            newpatient.setInsuranceNumber(neighborhoodRs.getString("InsuranceNumber"));
//            newpatient.setName(neighborhoodRs.getString("Name"));
//            newpatient.setSex(neighborhoodRs.getString("Sex"));
//            newpatient.setSystolicPressure(neighborhoodRs.getString("SystolicPressure"));
//            System.out.println(newpatient.getSystolicPressure());
//            //patientstore.addPatient();
//          }
//          
//        
//      }
//     // hugeconnect = conn;
//      conn.close();
      //System.out.println(neighborhoodRs.getString("SystolicPressure"));
        } 
      catch (SQLException ex) 
      {
            Logger.getLogger(jdbcConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
  
      return neighborhoodRs;
  }
  public ResultSet ageSearch(String Community,String minimumAge, String maximumAge,Connection con)
          //ResultSet neighborhoodRs=null;
         
  {    ResultSet neighborhoodRs=null; 
      try {
      String viewStatement = "SELECT persontbl.InsuranceNumber,persontbl.Name,persontbl.ApartmentNumber,persontbl.Sex,persontbl.Age,patientdata.SystolicPressure,patientdata.DiastolicPressure,persontbl.Community,persontbl.City FROM persontbl INNER JOIN patientdata on patientdata.InsuranceNumber = persontbl.InsuranceNumber WHERE persontbl.Age>? AND persontbl.Age<? AND Community=?";
      PreparedStatement pstmt2 = con.prepareStatement(viewStatement);
      pstmt2.setString(1, minimumAge);
      pstmt2.setString(2, maximumAge);
      pstmt2.setString(3, Community);
       neighborhoodRs = pstmt2.executeQuery(); 
        } catch (SQLException ex) {
            Logger.getLogger(jdbcConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
  return neighborhoodRs;
  }
}
