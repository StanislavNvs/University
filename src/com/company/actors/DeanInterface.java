package com.company.actors;

import com.company.group.GroupInterface;
import com.company.student.StudentInterface;

import java.util.Map;

public interface DeanInterface {

    void setStudentStatus(StudentInterface student, boolean status);
    Map<StudentInterface, GroupInterface> getStudents(String city);
    boolean moveStudent(StudentInterface student, GroupInterface to) throws Exception;
}
