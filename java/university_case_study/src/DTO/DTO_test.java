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
public class DTO_test {
    private int student_id;
    private int course_id;
    private String grade_code ;
    private String date ;

    public DTO_test(int student_id, int course_id, String grade_code, String date) {
        this.student_id = student_id;
        this.course_id = course_id;
        this.grade_code = grade_code;
        this.date = date;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public String getGrade_code() {
        return grade_code;
    }

    public void setGrade_code(String grade_code) {
        this.grade_code = grade_code;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
}
