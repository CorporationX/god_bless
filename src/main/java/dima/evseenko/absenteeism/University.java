package dima.evseenko.absenteeism;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class University {
    private final Map<Student.KeyPair, List<Student>> students = new HashMap<>();

    public void addStudent(Student student) {
        validateStudent(student);

        students.computeIfAbsent(student.getKeyPair(), k -> new ArrayList<>()).add(student);
    }

    public void addStudents(List<Student> students){
        validateStudents(students);

        students.forEach(this::addStudent);
    }

    public void deleteStudent(Student student) {
        validateStudent(student);

        if(students.containsKey(student.getKeyPair())){
            students.get(student.getKeyPair()).remove(student);
        }
    }

    public void deleteStudent(String name, Student.Faculty faculty, int year) {
        deleteStudent(new Student(name, faculty, year));
    }

    public void deleteStudents(List<Student> students) {
        validateStudents(students);

        students.forEach(this::deleteStudent);
    }

    public List<Student> findStudents(Student.KeyPair keyPair) {
        validateKeyPair(keyPair);

        return students.get(keyPair);
    }

    public List<Student> findStudents(Student.Faculty faculty, int year) {
        return findStudents(new Student.KeyPair(faculty, year));
    }

    public void printStudents(){
        students.forEach((k,v)->System.out.println(k+" "+v));
        System.out.println();
    }

    private void validateKeyPair(Student.KeyPair keyPair) {
        if(keyPair == null)
            throw new IllegalArgumentException("key pair is null");
        if(keyPair.getFaculty() == null)
            throw new IllegalArgumentException("faculty is null");
        if(keyPair.getYear() <= 0)
            throw new IllegalArgumentException("year is less than 0");
    }

    private void validateStudent(Student student) {
        if(student == null)
            throw new IllegalArgumentException("Student is null");
        if(student.getName() == null)
            throw new IllegalArgumentException("Student name is null");

        validateKeyPair(student.getKeyPair());
    }

    private void validateStudents(List<Student> students) {
        if(students == null)
            throw new IllegalArgumentException("Students is null");
    }
}
