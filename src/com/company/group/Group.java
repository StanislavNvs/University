package com.company.group;

import com.company.student.StudentInterface;

import java.util.*;


public class Group implements GroupInterface{

    private final String name;
    private final int courseNumber;
    private final Map<String, StudentInterface> students;

    public Group(String name, int courseNumber) throws Exception{

        if(name == null){

            throw new Exception("group's name can not be null");
        }

        if(courseNumber < 1){

            throw new Exception("course number can not be less then 1");
        }
        this.name = name;
        this.courseNumber = courseNumber;
        students = new HashMap<>();

        synchronized(groupsByCourse) {
            if (groupsByCourse.get(courseNumber) == null) {

                LinkedList<GroupInterface> linkedList = new LinkedList<>();
                linkedList.add(this);
                groupsByCourse.put(courseNumber, linkedList);
            } else {

                groupsByCourse.get(courseNumber).add(this);
            }
        }
    }

    @Override
    public String getName() {

        return name;
    }

    @Override
    public int getCourseNumber() {

        return courseNumber;
    }

    @Override
    public List<StudentInterface> getStudents() {

        synchronized (students) {

            return new ArrayList<>(students.values());
        }
    }

    @Override
    public boolean addStudent(StudentInterface student) throws NullPointerException{

        synchronized (students) {

            return students.putIfAbsent(student.getFullName(), student) == null;
        }
    }

    @Override
    public boolean deleteStudentFromGroup(StudentInterface student) throws NullPointerException {

        synchronized (students) {

            return students.remove(student.getFullName(), student);
        }
    }
}
