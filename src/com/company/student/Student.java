package com.company.student;

import com.company.group.GroupInterface;

public class Student implements StudentInterface{

    private final String fullName;
    private final String city;
    private boolean isStudy;

    public Student(String fullName, String city) throws Exception{

        if(fullName == null){

            throw new Exception("student's full name can not be null");
        }

        if(city == null){

            throw new Exception("city can not be null");
        }

        this.fullName = fullName;
        this.city = city;
        isStudy = false;
    }

    @Override
    public String getFullName() {

        return fullName;
    }

    @Override
    public String getCity() {

        return city;
    }

    @Override
    public boolean isStudy() {

        return isStudy;
    }

    @Override
    public void setStatus(boolean isStudy) {

        this.isStudy = isStudy;
    }
}
