/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author yousef saber
 */
public class DTO_students { 

    public DTO_students(int student_id, double GPA) {
        this.student_id = student_id;
        this.GPA = GPA;
    }
    private int student_id;
    private String f_name;
    private String l_name ;
    private String email ;
    private String DOB;
    private String city;
    private String street ;
    private String nationality ;
    private double GPA;
    private int department_id ;
    private String phone_number ; 

    public DTO_students(int student_id, String f_name, String l_name, String email, String DOB, String city, String street, String nationality, double GPA, int department_id, String phone_number) {
        this.student_id = student_id;
        this.f_name = f_name;
        this.l_name = l_name;
        this.email = email;
        this.DOB = DOB;
        this.city = city;
        this.street = street;
        this.nationality = nationality;
        this.GPA = GPA;
        this.department_id = department_id;
        this.phone_number = phone_number;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public String getF_name() {
        return f_name;
    }

    public void setF_name(String f_name) {
        this.f_name = f_name;
    }

    public String getL_name() {
        return l_name;
    }

    public void setL_name(String l_name) {
        this.l_name = l_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public double getGPA() {
        return GPA;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }

    public int getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }
}
