package com.section01;

import org.junit.jupiter.api.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.transaction.Transaction;

public class TrainingTests {
    private static EntityManagerFactory entityManagerFactory; //Entity를 만들기 위한 공장
    private EntityManager entityManager;

    @BeforeAll //최초 1회 실행
    public static void initFactory() {
        entityManagerFactory = Persistence.createEntityManagerFactory(/*환경등록*/"jpatest");
    }

    @BeforeEach //테스트 케이스별 실행 전마다 실행
    public void initManager() {
        //테스트 전에 null 값을 가지고 있는 entityManager에 생성하여 넣어준다.
        entityManager = entityManagerFactory.createEntityManager();
    }

    @AfterEach //테스트 케이스별 실행 후마다 실행
    public void closeManager() {
        entityManager.close();
    }

    @AfterAll //모든 테스트 종료후 1회 실행 (공장 닫아주기~ 종료 됐어요~)
    public static void closeFactory() {
        entityManagerFactory.close();
    }

    @Test
    public void student_subject_셋_다_들어가나요_1() {

        /*Student*/
        Student student = new Student().studentName("고민영").address("김포").phone("010-3423-23414").builder();
        entityManager.persist(student);
        System.out.println(student);

        /*Subject*/
        Subject subject = new Subject().subName("edldld").builder();
        entityManager.persist(subject);
        System.out.println(subject);

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        transaction.commit();

        /*Grade*/
        //GradePK에 값을 그냥 넣어줌...
        Student student1 = entityManager.find(Student.class, 1);
        Subject subject1 = entityManager.find(Subject.class, 1);

        System.out.println(student1);
        System.out.println(subject1);

        Grade grade = new Grade();
        grade.setGradePK(new GradePK(student1.getStudentNum(), subject1.getSubNum()));
        grade.setSemester("1학기");
        grade.setGradeScore(100);
        entityManager.persist(grade);

        transaction.begin();
        transaction.commit();
    }

}
