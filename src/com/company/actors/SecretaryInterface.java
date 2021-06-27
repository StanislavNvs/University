package com.company.actors;

import com.company.group.GroupInterface;
import com.company.student.StudentInterface;

import java.util.List;

public interface SecretaryInterface {

    void createGroup(String name, int courseNumber) throws Exception;
    boolean deleteGroup(GroupInterface group);
    List<StudentInterface> getStudents(GroupInterface group) throws Exception;
    List<StudentInterface> getStudents(int courseNumber);
    boolean addStudent(StudentInterface student, GroupInterface group) throws Exception;
}
