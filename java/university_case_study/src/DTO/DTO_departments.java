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
public class DTO_departments {
    private int departments_id;
    private String department_name;
    private String departmnt_desc ;

    public int getDepartments_id() {
        return departments_id;
    }

    public void setDepartments_id(int departments_id) {
        this.departments_id = departments_id;
    }

    public String getDepartment_name() {
        return department_name;
    }

    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }

    public String getDepartmnt_desc() {
        return departmnt_desc;
    }

    public void setDepartmnt_desc(String departmnt_desc) {
        this.departmnt_desc = departmnt_desc;
    }

    public DTO_departments(int departments_id, String department_name, String departmnt_desc) {
        this.departments_id = departments_id;
        this.department_name = department_name;
        this.departmnt_desc = departmnt_desc;
    }
}
