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
public class DTO_courses { 
    private int course_id;
    private String course_name;
    private String course_describtion ;
    private String credit_hours ;
    private int instractor_id;
    private int numStudents;
    private double avgGpa;

    public DTO_courses(int course_id, int numStudents, double avgGpa) {
        this.course_id = course_id;
        this.numStudents = numStudents;
        this.avgGpa = avgGpa;
    }

    public int getNumStudents() {
        return numStudents;
    }

    public void setNumStudents(int numStudents) {
        this.numStudents = numStudents;
    }

    public double getAvgGpa() {
        return avgGpa;
    }

    public void setAvgGpa(double avgGpa) {
        this.avgGpa = avgGpa;
    }


    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getCourse_describtion() {
        return course_describtion;
    }

    public void setCourse_describtion(String course_describtion) {
        this.course_describtion = course_describtion;
    }

    public String getCredit_hours() {
        return credit_hours;
    }

    public void setCredit_hours(String credit_hours) {
        this.credit_hours = credit_hours;
    }

    public int getInstractor_id() {
        return instractor_id;
    }

    public void setInstractor_id(int instractor_id) {
        this.instractor_id = instractor_id;
    }

    public DTO_courses(int course_id, String course_name, String course_describtion, String credit_hours, int instractor_id) {
        this.course_id = course_id;
        this.course_name = course_name;
        this.course_describtion = course_describtion;
        this.credit_hours = credit_hours;
        this.instractor_id = instractor_id;
    }
}
