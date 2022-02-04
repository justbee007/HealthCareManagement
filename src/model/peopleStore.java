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
public class peopleStore {
    private ArrayList <Person> peopleDb;
    public peopleStore()
    { this.peopleDb = new ArrayList<Person>();
    }
    public ArrayList<Person> getPeopleDb() {
        return peopleDb;
    }

    public void setPeopleDb(ArrayList<Person> peopleDb) {
        this.peopleDb = peopleDb;
    }
    public Person addperson(Person p)
    { //Person newperson = new Person();
    peopleDb.add(p);
    return p;
    }
    
}
