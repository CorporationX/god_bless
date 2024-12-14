package ru.kraiush.BJS2_20267;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class AppDoubleCache {

    public static void main(String[] args) {

        Map<Student, Map<Subject, Integer>> mapStudents;

        Map<Subject, List<Student>> mapSubjects= new HashMap<>();

        AppDoubleCache app = new AppDoubleCache();

        List<Subject> subjects = app.getSubjects();

        List<Student> students = app.getStudents();

        StudentService studentService = new StudentService();

        mapStudents = studentService.initializeStudentsWithSubjects(students, subjects);

        System.out.println("init map of <Students>");
        mapStudents.forEach((K, V) -> System.out.println("key: " + K + " value: " + V));

        mapStudents = studentService.addStudentWithSubjects(students, subjects, mapStudents, "Afrodita");

        System.out.println("\nmap of <Students> with new user");
        mapStudents.forEach((K, V) -> System.out.println("key: " + K + " value: " + V));

        Student student = students.get(ThreadLocalRandom.current().nextInt(0, students.size()));

        String newSubject = "history";

        System.out.println("\nadd a new subject: <" + newSubject + "> to the student: " + student);

        mapStudents =
                studentService.addSubjectToStudent(
                        student,
                        mapStudents,
                        newSubject,
                        subjects);

        mapStudents.forEach((K, V) -> System.out.println("key: " + K + " value: " + V));

        studentService.deleteStudent(student, students, mapStudents);

        System.out.println("\nafter deleting the student: " + student);
        System.out.println("students: " + students);

        Subject subject = subjects.stream()
                .filter(s -> newSubject.equals(s.getName()))
                .findAny()
                .orElse(null);

        List<Student> someStudents = new ArrayList<>();
        someStudents.add(students.get(0));
        someStudents.add(students.get(students.size() - 1));

        mapStudents = studentService.addSubjectToSomeStudents(
                someStudents,
                subject,
                mapStudents);

        System.out.println("\n add new Subject to some students");
        mapStudents.forEach((K, V) -> System.out.println("key: " + K + " value: " + V));

        List<Student> listStidentsWithSubject = studentService.
                listStidentsWithSubject(students, mapStudents, newSubject);

        System.out.println("\nstudents with newSubject: <" + newSubject + ">"); //.entrySet());
        System.out.println(listStidentsWithSubject);
        student = listStidentsWithSubject.get(ThreadLocalRandom.current().nextInt(0, students.size() - 1));

        System.out.println("\nstudent to remove the subject: " + student + " - <" + newSubject + ">");

        studentService.deleteSubjectFromStudent(
                student,
                newSubject,
                mapStudents);

        System.out.println("\nafter remove()");
        mapStudents.forEach((K, V) -> System.out.println("key: " + K + " value: " + V));

        for(Subject subj: subjects) {
            mapSubjects.put(subj, studentService.listStidentsWithSubject(students, mapStudents, subj.getName()));
        }
        System.out.println("\nSubjects with their students");
        mapSubjects.forEach((K, V) -> System.out.println("key: " + K + " value: " + V));
    }

    public List<Student> getStudents() {

        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Aloe"));
        students.add(new Student(2, "Berns"));
        students.add(new Student(3, "Catty"));

        return students;
    }

    public List<Subject> getSubjects() {

        List<Subject> subjects = new ArrayList<>();
        subjects.add(new Subject(1, "Mathematic"));
        subjects.add(new Subject(2, "Physics"));
        subjects.add(new Subject(3, "Poetry"));

        return subjects;
    }
}
