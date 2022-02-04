/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author ABHI
 */
public class patientStore {
   private ArrayList <Patient> patientDb; 

    public ArrayList<Patient> getPatientDb() {
        return patientDb;
    }

    public void setPatientDb(ArrayList<Patient> patientDb) {
        this.patientDb = patientDb;
    }
        public Patient addPatient()
    { 
        Patient p = new Patient();
        patientDb.add(p);
        return p;
    
    
    }
}
