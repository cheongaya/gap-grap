package com.roovalant.practice.ch07;

import com.roovalant.practice.ch07.school.School;
import com.roovalant.practice.ch07.school.Score;
import com.roovalant.practice.ch07.school.Student;
import com.roovalant.practice.ch07.school.Subject;
import com.roovalant.practice.ch07.school.report.GenerateGradeReport;
import com.roovalant.practice.ch07.utils.Define;

public class TestMain {

    School goodSchool = School.getInstance();
    Subject korean;
    Subject math;
    Subject dance;

    GenerateGradeReport gradeReport = new GenerateGradeReport();

    // 테스트 과목 생성
    public void createSubject() {
        korean = new Subject("국어", Define.KOREAN);
        math = new Subject("수학", Define.MATH);
        dance = new Subject("댄스", Define.DANCE);

        dance.setGradeType(Define.PF_TYPE);

        goodSchool.addSubject(korean);
        goodSchool.addSubject(math);
        goodSchool.addSubject(dance);
    }

    // 테스트 학생 생성
    public void createStudent() {
        Student student1 = new Student(211001, "강감찬", korean);
        Student student2 = new Student(211002, "김유신", math);
        Student student3 = new Student(211003, "신사당", korean);
        Student student4 = new Student(211004, "이순신", korean);
        Student student5 = new Student(211005, "홍길동", math);

        goodSchool.addStudent(student1);
        goodSchool.addStudent(student2);
        goodSchool.addStudent(student3);
        goodSchool.addStudent(student4);
        goodSchool.addStudent(student5);

        korean.register(student1);
        korean.register(student2);
        korean.register(student3);
        korean.register(student4);
        korean.register(student5);

        math.register(student1);
        math.register(student2);
        math.register(student3);
        math.register(student4);
        math.register(student5);

        dance.register(student1);
        dance.register(student2);
        dance.register(student3);

        addScoreForStudent(student1, korean, 95);
        addScoreForStudent(student1, math, 56);
        addScoreForStudent(student1, dance, 95);

        addScoreForStudent(student2, korean, 95);
        addScoreForStudent(student2, math, 95);
        addScoreForStudent(student2, dance, 85);

        addScoreForStudent(student3, korean, 100);
        addScoreForStudent(student3, math, 88);
        addScoreForStudent(student3, dance, 55);

        addScoreForStudent(student4, korean, 89);
        addScoreForStudent(student4, math, 95);

        addScoreForStudent(student5, korean, 85);
        addScoreForStudent(student5, math, 56);
    }

    // 과목별 성적 입력
    public void addScoreForStudent(Student student, Subject subject, int point) {
        Score score = new Score(student.getStudentId(), subject, point);
        student.addSubjectScore(score);
    }

    public static void main(String[] args) {
        TestMain test = new TestMain();

        test.createSubject();
        test.createStudent();;

        String report = test.gradeReport.getReport(); // 성적 결과 생성
        System.out.println(report); // 출력
    }
}
