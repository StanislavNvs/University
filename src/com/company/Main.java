package com.company;

import com.company.actors.Dean;
import com.company.actors.Secretary;
import com.company.actors.Teacher;
import com.company.group.Group;
import com.company.group.GroupInterface;
import com.company.student.Student;
import com.company.student.StudentInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) throws Exception {

        List<Student> students = new ArrayList<>();

        Dean dean = new Dean();
        Teacher teacher = new Teacher();
        Secretary secretary = new Secretary();

        for(int i = 1; i < 11; ++i){

            new Group("Name" + i , i%3 + 1);
        }

        for(int i = 1; i < 101; ++i){

            students.add(new Student("FullName" + i, "City" + i));
        }

        Random random = new Random(System.currentTimeMillis());
        for(StudentInterface student: students){

            secretary.addStudent(student, GroupInterface.getGroups().get(random.nextInt(GroupInterface.getGroups().size()-1))) ;
        }

        for(StudentInterface student: secretary.getStudents(1)){

            System.out.println(student.getFullName());
        }
    }
}
