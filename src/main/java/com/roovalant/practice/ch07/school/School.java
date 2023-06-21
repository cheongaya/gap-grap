package com.roovalant.practice.ch07.school;

import java.util.ArrayList;

public class School {
    // 학교는 한개이기 때문에, 싱글톤 패턴으로 작성
    private static School instance = new School();

    private ArrayList<Student> studentList = new ArrayList<>();
    private ArrayList<Subject> subjectList = new ArrayList<>();

    private School() {}

    public static School getInstance() {
        if (instance == null)
            instance = new School();
        return instance;
    }

    public static void setInstance(School instance) {
        School.instance = instance;
    }

    public ArrayList<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(ArrayList<Student> studentList) {
        this.studentList = studentList;
    }

    public ArrayList<Subject> getSubjectList() {
        return subjectList;
    }

    public void setSubjectList(ArrayList<Subject> subjectList) {
        this.subjectList = subjectList;
    }

    public void addStudent(Student student) {
        studentList.add(student);
    }

    public void addSubject(Subject subject) {
        subjectList.add(subject);
    }
}
