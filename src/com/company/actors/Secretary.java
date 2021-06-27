package com.company.actors;

import com.company.group.Group;
import com.company.group.GroupInterface;
import com.company.student.StudentInterface;

import java.util.ArrayList;
import java.util.List;

public class Secretary implements SecretaryInterface{


    @Override
    public void createGroup(String name, int courseNumber) throws Exception {

        new Group(name, courseNumber);
    }

    @Override
    public boolean deleteGroup(GroupInterface group) {

        if(GroupInterface.deleteGroup(group)){

            for(StudentInterface student: group.getStudents()){

                student.setStatus(false);
            }
            return true;
        }

        return false;
    }

    @Override
    public List<StudentInterface> getStudents(GroupInterface group) throws NullPointerException {

        return group.getStudents();
    }

    @Override
    public List<StudentInterface> getStudents(int courseNumber) {

        List<StudentInterface> students = new ArrayList<>();
        for(GroupInterface group: GroupInterface.getGroupsByCourse().get(courseNumber)){

            students.addAll(group.getStudents());
        }

        return students;
    }

    @Override
    public boolean addStudent(StudentInterface student, GroupInterface group) throws Exception{

        if(group.addStudent(student)){

            student.setStatus(true);
            return true;
        }
        return false;
    }
}
