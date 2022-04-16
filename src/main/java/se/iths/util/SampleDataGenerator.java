package se.iths.util;


import se.iths.entity.Student;
import se.iths.entity.Subject;
import se.iths.entity.Teacher;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Singleton
@Startup
public class SampleDataGenerator {

    @PersistenceContext
    EntityManager entityManager;

    @PostConstruct
    public void generateData() {

        Student student1 = new Student("jan", "kvist", "jan.kvist@gmail.com", "0732374124");
        Student student2 = new Student("tomas", "sten", "tomas.sten@gmail.com", "0722424126");
        Student student3 = new Student("jess", "lika", "jess.lika@gmail.com", "0762374123");
        Student student4= new Student("maria", "kvist", "maria.kvist@gmail.com", "0762521223");
        Student student5 = new Student("kalle", "lutent", "kalle.lutent@gmail.com", "0732374135");
        Student student6 = new Student("tommy", "lundin", "tommy.lundin@gmail.com", "0732524122");

        Teacher teacher1 = new Teacher();
        teacher1.setName("Lars Mattsson");
        Teacher teacher2 = new Teacher();
        teacher2.setName("Karin Somera");
        Teacher teacher3 = new Teacher();
        teacher3.setName("Maria Bilic");

        Subject subject = new Subject();
        subject.setName("Matte 2");

        subject.setTeacher(teacher1);
        subject.addStudent(student1);
        subject.addStudent(student6);


        entityManager.persist(subject);
        entityManager.persist(teacher2);
        entityManager.persist(teacher3);
        entityManager.persist(student2);
        entityManager.persist(student3);
        entityManager.persist(student4);
        entityManager.persist(student5);





    }

}
