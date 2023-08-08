package com.section01;

import javax.persistence.*;

//과목
@Entity(name = "section01_subject")
@Table(name = "tbl_section01_subject")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //데이터베이스에서 관리하는 전략 사용
    @Column(name = "sub_num", nullable = false)
    private int subNum;    //과목번호
    @Column(name = "sub_name" , nullable = false)
    private String subName;     //과목명

    public Subject() {
    }

    public Subject(int subNum, String subName) {
        this.subNum = subNum;
        this.subName = subName;
    }

    public int getSubNum() {
        return subNum;
    }

    public void setSubNum(int subNum) {
        this.subNum = subNum;
    }

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "subNum=" + subNum +
                ", subName='" + subName + '\'' +
                '}';
    }


    /*빌더패턴*/

    public Subject subNum(int subNum) {
        this.subNum = subNum;
        return this;
    }
    //빌더 설정
    public Subject builder(){
        return new Subject(subNum, subName);
    }

    public Subject subName(String subName) {
        this.subName = subName;
        return this;
    }
}
