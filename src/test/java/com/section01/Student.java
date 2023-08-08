package com.section01;

import javax.persistence.*;

@Entity(name = "section01_student")
@Table(name = "tbl_section01_student")
public class Student {

    @Id
    @Column(name = "stu_num" , nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY) //데이터베이스에서 관리하는 전략 사용
    private int studentNum;                 //학생번호
    @Column(name = "stu_name" , nullable = false)
    private  String studentName;        //학생명
    @Column(name = "stu_phone" , nullable = false)
    private String  phone;                  //전화번호
    @Column(name = "stu_address")
    private String address;                 //주소

    //생성자
    public Student() {
    }

    public Student(int studentNum, String studentName, String phone, String address) {
        this.studentNum = studentNum;
        this.studentName = studentName;
        this.phone = phone;
        this.address = address;
    }

    public int getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(int studentNum) {
        this.studentNum = studentNum;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String number) {
        this.phone = number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentNum=" + studentNum +
                ", studentName='" + studentName + '\'' +
                ", phone ='" + phone+ '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    /*빌더 패턴*/

    public Student studentNum(int studentNum) {
        this.studentNum = studentNum;
        return this;
    }

    public Student studentName(String studentName) {
        this.studentName = studentName;
        return this;
    }

    public Student phone(String phone) {
        this.phone = phone;
        return this;
    }

    public Student address(String address) {
        this.address = address;
        return this;
    }
    public Student builder(){
        return new Student(studentNum, studentName, phone, address);
    }
}
