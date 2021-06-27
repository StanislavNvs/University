package com.company.actors;

import com.company.group.GroupInterface;
import com.company.student.StudentInterface;

import java.util.List;
import java.util.Map;

public interface TeacherInterface {

    List<StudentInterface> getStudents(GroupInterface group);
    Map<StudentInterface, GroupInterface> findStudentsByFullName(String fullName);
}
