package se.iths.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table(name = "subjects")
@Entity
public class Subject {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "students_subjects")
    private List<Student> students = new ArrayList<>();


    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Teacher teacher = null;

    public Subject() {
    }

    public List<Student> getStudents(){
        return students;
    }
    public void addStudent(Student student){
        if( student == null || this.students.contains(student) )
            return;

        student.getSubjects().add(this);
        this.students.add(student);
    }
    public void removeStudent(Student student){
        if( student == null || !this.students.contains(student) )
            return;

        student.getSubjects().remove(this);
        this.students.remove(student);
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        if(teacher == null || this.teacher == teacher)
            return;

        if(this.teacher != null)
            this.teacher.getSubjects().remove(this);
        teacher.getSubjects().add(this);
        this.teacher = teacher;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Subject subject = (Subject) o;

        if (!id.equals(subject.id)) return false;
        if (name != null ? !name.equals(subject.name) : subject.name != null) return false;
        if (students != null ? !students.equals(subject.students) : subject.students != null) return false;
        return teacher != null ? teacher.equals(subject.teacher) : subject.teacher == null;
    }


}
