package com.roovalant.gapgrap.practice.ch07.grade;

// 주요 과목 학점에 대한 클래스 구현
public class PassFailEvaluation implements GradeEvaluation{
    @Override
    public String getGrade(int point) {
        String grade;

        if (point >= 70)
            grade = "P";
        else
            grade = "F";

        return grade;
    }
}
