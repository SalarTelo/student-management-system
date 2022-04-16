package se.iths.service;

import se.iths.entity.Student;
import se.iths.entity.Subject;
import se.iths.entity.Subject;
import se.iths.entity.Teacher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class SubjectService {

    @PersistenceContext
    EntityManager entityManager;

    public void createSubject(Subject data){
        entityManager.persist(data);
    }

    public void updateSubject(Subject data){
        entityManager.merge(data);
    }

    public Subject findSubjectById(Long id){
        return entityManager.find(Subject.class, id);
    }

    public List<Subject> getAllSubjects(){
        return entityManager.createQuery("SELECT i from Subject i", Subject.class).getResultList();
    }
    public Subject addStudent(Subject subject, Student student){
        subject.addStudent(student);
        entityManager.merge(subject);
        return subject;
    }
    public Subject removeStudent(Subject subject, Student student){
        subject.removeStudent(student);
        entityManager.merge(subject);
        return subject;
    }
    public Subject setTeacher(Subject subject, Teacher teacher){
        subject.setTeacher(teacher);
        entityManager.merge(subject);
        return subject;
    }
    public void deleteSubject(Subject subject){
        if(!entityManager.contains(subject))
            entityManager.merge(subject);
        entityManager.remove(subject);
    }

}
