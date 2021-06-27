package com.company.course;

import com.company.group.GroupInterface;
import com.company.student.StudentInterface;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Course {

    private final int number;
    private final LinkedList<GroupInterface> groups;
    private final Map<StudentInterface, GroupInterface> studentsAndGroups;

    public Course(int number){

        this.number = number;
        groups = new LinkedList<>();
        studentsAndGroups = new HashMap<>();
    }
}
