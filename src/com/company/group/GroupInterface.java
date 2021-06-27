package com.company.group;

import com.company.student.Student;
import com.company.student.StudentInterface;

import java.util.*;

public interface GroupInterface {

    Map<Integer, LinkedList<GroupInterface>> groupsByCourse = new HashMap<>();
    String getName();
    int getCourseNumber();
    List<StudentInterface> getStudents();
    boolean addStudent(StudentInterface student) throws Exception;
    boolean deleteStudentFromGroup(StudentInterface student);

    static List<GroupInterface> getGroups() {

        List<GroupInterface> groups = new ArrayList<>();

        synchronized (groupsByCourse) {
            for (LinkedList<GroupInterface> list : groupsByCourse.values()) {

                groups.addAll(list);
            }
        }

        return groups;
    }

    static Map<Integer, LinkedList<GroupInterface>> getGroupsByCourse(){

        return groupsByCourse;
    }
    static boolean deleteGroup(GroupInterface group){

        synchronized (groupsByCourse){

            for (LinkedList<GroupInterface> list : groupsByCourse.values()) {

                if(list.remove(group)){

                    return true;
                }
            }

            return false;
        }
    }

    static boolean deleteStudent(StudentInterface student){

        for (GroupInterface group : getGroups()) {

            if(group.deleteStudentFromGroup(student)){

                return true;
            }
        }

        return false;
    }
}
