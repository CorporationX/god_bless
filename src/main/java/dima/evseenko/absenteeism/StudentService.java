package dima.evseenko.absenteeism;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Getter
public class StudentService {
    private final Map<FacultyYearKeyPair, List<Student>> students = new HashMap<>();

    public void addStudent(Student student) {
        if(Objects.nonNull(student)) {
            students.computeIfAbsent(student.getFacultyYearKeyPair(), k -> new ArrayList<>()).add(student);
        }
    }

    public void addStudents(List<Student> students){
        if(Objects.nonNull(students)){
            students.forEach(this::addStudent);
        }
    }

    public void deleteStudent(Student student) {
        if(students.containsKey(student.getFacultyYearKeyPair())){
            students.get(student.getFacultyYearKeyPair()).remove(student);
        }
    }

    public void deleteStudent(String name, Faculty faculty, int year) {
        deleteStudent(new Student(name, faculty, year));
    }

    public void deleteStudents(List<Student> students) {
        students.forEach(this::deleteStudent);
    }

    public List<Student> findStudents(FacultyYearKeyPair keyPair) {
        return students.get(keyPair);
    }

    public List<Student> findStudents(Faculty faculty, int year) {
        return findStudents(new FacultyYearKeyPair(faculty, year));
    }

    public void printStudents(){
        students.forEach((k,v)->System.out.println(k+" "+v));
        System.out.println();
    }
}
