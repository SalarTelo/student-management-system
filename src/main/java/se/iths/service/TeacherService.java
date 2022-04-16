package se.iths.service;

import se.iths.entity.Teacher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class TeacherService {

    @PersistenceContext
    EntityManager entityManager;

    public Teacher createTeacher(Teacher teacher){
        entityManager.persist(teacher);
        return teacher;
    }

    public Teacher updateTeacher(Teacher teacher){
        entityManager.merge(teacher);
        return teacher;
    }
    public void removeTeacher(Teacher teacher){
        entityManager.remove(teacher);
    }
    public Teacher findTeacherById(Long id){
        return entityManager.find(Teacher.class, id);
    }

    public List<Teacher> getAllTeachers(){
        return entityManager.createQuery("SELECT i from Teacher i", Teacher.class).getResultList();
    }

}
