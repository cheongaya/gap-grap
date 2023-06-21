package com.roovalant.gapgrap.practice.ch07;

import com.roovalant.gapgrap.practice.ch07.utils.Define;
import net.bytebuddy.implementation.bytecode.collection.ArrayLength;

import java.util.ArrayList;

public class Subject {

    private int subjectId; // 과목 고유번호
    private String subjectName; // 과목 이름
    private int gradeType; // 과목 평가 방법 (기본은 A, B 방식)

    // 수강 신청한 학생 리스트 (register() 메서드를 호출하면 리스트에 추가 됨)
    private ArrayList<Student> studentList = new ArrayList<>();

    public Subject(int subjectId, String subjectName, int gradeType) {
        this.subjectId = subjectId;
        this.subjectName = subjectName;
        this.gradeType = Define.AB_TYPE; // 기본적으로 A, B 타입
    }

    // 수강신청 메서드
    public void register(Student student) {
        studentList.add(student);
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public int getGradeType() {
        return gradeType;
    }

    public void setGradeType(int gradeType) {
        this.gradeType = gradeType;
    }
}
