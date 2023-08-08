package com.section01;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class GradePK implements Serializable {

    @Column(name = "sub_num")
    private int subNum;    //과목번호


    @Column(name = "stu_num" )
    private int studentNum;             //학생번호


    public GradePK() {
    }

    public GradePK(int subNum, int studentNum) {
        this.subNum = subNum;
        this.studentNum = studentNum;
    }

    public int getSubNum() {
        return subNum;
    }

    public void setSubNum(int subNum) {
        this.subNum = subNum;
    }

    public int getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(int studentNum) {
        this.studentNum = studentNum;
    }

    @Override
    public String toString() {
        return "GradePK{" +
                "subNum=" + subNum +
                ", studentNum=" + studentNum +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GradePK gradePK = (GradePK) o;
        return subNum == gradePK.subNum && studentNum == gradePK.studentNum;
    }

    @Override
    public int hashCode() {
        return Objects.hash(subNum, studentNum);
    }


}
