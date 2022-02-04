/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author ABHI
 */
public class Patient {
    private String insuranceNumber;
    private String name;
    private int age;
    private String sex;
    private String ApartmentNumber;
    private String Community;
    private String City;
    private String SystolicPressure;
    private String DiastolicPressure;

    public String getInsuranceNumber() {
        return insuranceNumber;
    }

    public void setInsuranceNumber(String insuranceNumber) {
        this.insuranceNumber = insuranceNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getApartmentNumber() {
        return ApartmentNumber;
    }

    public void setApartmentNumber(String ApartmentNumber) {
        this.ApartmentNumber = ApartmentNumber;
    }

    public String getCommunity() {
        return Community;
    }

    public void setCommunity(String Community) {
        this.Community = Community;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String City) {
        this.City = City;
    }

    public String getSystolicPressure() {
        return SystolicPressure;
    }

    public void setSystolicPressure(String SystolicPressure) {
        this.SystolicPressure = SystolicPressure;
    }

    public String getDiastolicPressure() {
        return DiastolicPressure;
    }

    public void setDiastolicPressure(String DiastolicPressure) {
        this.DiastolicPressure = DiastolicPressure;
    }
}
