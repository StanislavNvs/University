package com.company.actors;

import com.company.group.GroupInterface;
import com.company.student.StudentInterface;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Teacher implements TeacherInterface{

    @Override
    public List<StudentInterface> getStudents(GroupInterface group) throws NullPointerException{

        return group.getStudents();
    }

    @Override
    public Map<StudentInterface, GroupInterface> findStudentsByFullName(String fullName) {


        Map<StudentInterface, GroupInterface> studentsAndGroups = new HashMap<>();
        for(GroupInterface group: GroupInterface.getGroups()){

             for(StudentInterface student: group.getStudents()){

                 if(student.getFullName().equals(fullName)){

                     studentsAndGroups.put(student, group);
                 }
             }
        }

        return studentsAndGroups;
    }
}
