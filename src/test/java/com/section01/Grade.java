package com.section01;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

//학점
@Entity(name = "section01_grade")
@Table(name = "tbl_section01_grade")
public class Grade {
    @EmbeddedId
    private GradePK gradePK;

    @Column(name = "grade_semester", nullable = false)
    private String Semester;                    //학기

    @Column(name = "grade_score" , nullable = false)
    private int gradeScore;         //과목점수

    public Grade() {
    }

    public Grade(GradePK gradePK, String semester, int gradeScore) {
        this.gradePK = gradePK;
        Semester = semester;
        this.gradeScore = gradeScore;
    }

    public GradePK getGradePK() {
        return gradePK;
    }

    public void setGradePK(GradePK gradePK) {
        this.gradePK = gradePK;
    }

    public String getSemester() {
        return Semester;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "gradePK=" + gradePK +
                ", Semester='" + Semester + '\'' +
                ", gradeScore=" + gradeScore +
                '}';
    }

    public void setSemester(String semester) {
        Semester = semester;
    }

    public int getGradeScore() {
        return gradeScore;
    }

    public void setGradeScore(int gradeScore) {
        this.gradeScore = gradeScore;
    }

    //빌더 패턴

    public Grade semester(String semester) {
        Semester = semester;
        return this;
    }

    public Grade gradeScore(int gradeScore) {
        this.gradeScore = gradeScore;
        return this;
    }

    public Grade builder(){
        return new Grade(gradePK, Semester, gradeScore);
    }
}
