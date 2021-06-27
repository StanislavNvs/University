package com.company.actors;

import com.company.group.GroupInterface;
import com.company.student.StudentInterface;

import java.util.HashMap;
import java.util.Map;

public class Dean implements DeanInterface{


    @Override
    public void setStudentStatus(StudentInterface student, boolean status) throws NullPointerException{

        student.setStatus(status);
    }

    @Override
    public Map<StudentInterface, GroupInterface> getStudents(String city) {

        if(city == null){

            throw new NullPointerException();
        }
        Map<StudentInterface, GroupInterface> studentsAndGroups = new HashMap<>();

        for(GroupInterface group: GroupInterface.getGroups()){

            for(StudentInterface student: group.getStudents()){

                if(student.getCity().equals(city)){

                    studentsAndGroups.put(student, group);
                }
            }
        }

        return studentsAndGroups;
    }

    @Override
    public boolean moveStudent(StudentInterface student, GroupInterface to) throws Exception {

        if(!GroupInterface.deleteStudent(student)){

            return false;
        }

        if(to.addStudent(student)){

            student.setStatus(true);
            return true;
        }

        return false;
    }
}
