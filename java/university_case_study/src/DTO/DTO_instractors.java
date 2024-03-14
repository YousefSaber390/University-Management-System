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
public class DTO_instractors {
    private int instractor_id;
    private String instractor_name;
    private int department_id ;

    public int getInstractor_id() {
        return instractor_id;
    }

    public void setInstractor_id(int instractor_id) {
        this.instractor_id = instractor_id;
    }

    public String getInstractor_name() {
        return instractor_name;
    }

    public void setInstractor_name(String instractor_name) {
        this.instractor_name = instractor_name;
    }

    public DTO_instractors(int instractor_id, String instractor_name, int department_id) {
        this.instractor_id = instractor_id;
        this.instractor_name = instractor_name;
        this.department_id = department_id;
    }

    public int getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }

   
    }
    

