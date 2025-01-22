package com.hema;

import com.hema.model.Student;
import com.hema.repository.HQLQuery;
import com.hema.service.StudentService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // StudentService.createTable();
        //StudentService.addStudents();
        // StudentService.findStudents();
        // StudentService.updateStudents();
        //StudentService.deleteStudents();
        // HQLQuery.getStudentUsingObject();
        // HQLQuery.useNameParameter();
        HQLQuery.useNamedQuery();


    }
}