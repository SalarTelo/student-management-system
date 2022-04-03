package se.iths.service;

import se.iths.entity.Student;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class StudentService {

    @PersistenceContext
    EntityManager entityManager;

    public void createStudent(Student data){
        entityManager.persist(data);
    }

    public void updateStudent(Student data){
        entityManager.merge(data);
    }

    public Student findStudentById(Long id){
        return entityManager.find(Student.class, id);
    }
    public List<Student> findStudentByEmail(String email){
        return entityManager.createQuery("SELECT i FROM Student i WHERE i.email = '" + email + "'", Student.class).getResultList();
    }
    public List<Student> getAllStudents(){
        return entityManager.createQuery("SELECT i from Student i", Student.class).getResultList();
    }

    public List<Student> findStudentsByLastName(String name) {
        return entityManager.createQuery("SELECT i FROM Student i WHERE i.lastName = '" + name + "'", Student.class).getResultList();
    }
    public void deleteStudent(Long id){
        Student student = entityManager.find(Student.class, id);
        entityManager.remove(student);
    }

}
