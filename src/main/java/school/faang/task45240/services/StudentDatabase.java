package school.faang.task45240.services;

import school.faang.task45240.model.Student;
import school.faang.task45240.model.Subject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentDatabase {

    private Map<Student, Map<Subject, Integer>> gradedStudents;
    private Map<Subject, List<Student>> studentSubjects;

    public StudentDatabase() {
        gradedStudents = new HashMap<>();
        studentSubjects = new HashMap<>();

    }

    public void newStudent(Student student, Map<Subject, Integer> subjectGraded) {
//Добавление нового студента и его предметов с оценками.
        gradedStudents.putIfAbsent(student, subjectGraded);
    }

    public void addSubjectToStudent(Student student, Map<Subject, Integer> gradedSubjects) {
//Добавление нового предмета для существующего студента с оценкой.
        //studentsSubjects.get(student).
        for (Map.Entry<Subject, Integer> entry : gradedSubjects.entrySet()) {
            gradedStudents.get(student).putIfAbsent(entry.getKey(), entry.getValue());
        }


    }

    public void deleteStudent(Student student) {
//Удаление студента и его предметов.
        gradedStudents.remove(student);

    }

    public void printGradedStudents() {
//Вывод списка всех студентов и их оценок по предметам.
        System.out.println("=======");
        System.out.println("printGradedStudents: ");
        for (Map.Entry<Student, Map<Subject, Integer>> entry : gradedStudents.entrySet()) {
            System.out.println(entry.getKey() + " has grades:");
            System.out.println(entry.getValue());
        }
        System.out.println("=======");
    }

    public void addNewSubject(Subject subject, List<Student> students) {
//Добавление нового предмета и списка студентов, изучающих его.
        studentSubjects.putIfAbsent(subject, students); //Map<Subject, List<Student>>
    }

    public void addStudentToSubject(Student student, Subject subject) {
//Добавление студента к существующему предмету.
        if (studentSubjects.containsKey(subject)) {
            if (!studentSubjects.get(subject).contains(student)) {
                studentSubjects.get(subject).add(student);
            }
        }else{
            System.out.println("Subject " + subject + " is absent. Unable to add student to it. ");
        }
    }

    public void removeStudentFromSubject(Student student, Subject subject) {
//Удаление студента из предмета.
        if (studentSubjects.containsKey(subject)) {
            studentSubjects.get(subject).remove(student);
        }else{
            System.out.println("Subject " + subject + " is absent. Unable to delete student from it. ");
        }

    }

    public void printStudentSubjects() {
//Вывод списка всех предметов и студентов, изучающих их.
        System.out.println("=======");
        System.out.println("printStudentSubjects: ");
        for (Map.Entry<Subject, List<Student>> entry : studentSubjects.entrySet()) {
            System.out.println("Subject: " + entry.getKey());
            System.out.println(entry.getValue());
        }
        System.out.println("=======");
    }

}
