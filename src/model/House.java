/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author ABHI
 */
public class House {
    public ResultSet housesearch(Connection con, String houseNumber)
    {   ResultSet rs = null;
        try {
        
        jdbcConnection obj = new jdbcConnection();
        
        String viewStatement = "SELECT persontbl.InsuranceNumber,persontbl.Name,persontbl.Sex,persontbl.Age,patientdata.SystolicPressure,patientdata.DiastolicPressure,persontbl.Community,persontbl.City,persontbl.ApartmentNumber FROM persontbl INNER JOIN patientdata on patientdata.InsuranceNumber = persontbl.InsuranceNumber WHERE persontbl.ApartmentNumber=?";
        PreparedStatement pstmt = con.prepareStatement(viewStatement);
        pstmt.setString(1,houseNumber);
        rs = pstmt.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(House.class.getName()).log(Level.SEVERE, null, ex);
        }
    return rs;
    }
}
