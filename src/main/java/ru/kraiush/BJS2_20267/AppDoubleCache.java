package ru.kraiush.BJS2_20267;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class AppDoubleCache {

    public static void main(String[] args) {

        Map<Student, Map<Subject, Integer>> mapStudents = new HashMap<>();

        Map<Subject, List<Student>> mapSubject = new HashMap<>();

        AppDoubleCache app = new AppDoubleCache();

        List<Subject> subjects=  app.getSubjects();

        List<Student>  students= app.getStudents();

        StudentService studentService = new StudentService();

        mapStudents= studentService.initializeStudentsWithSubjects( students, subjects);

        System.out.println("map of <Students> init");
        mapStudents.forEach((K,V) -> System.out.println("key: "+ K + " value: " + V));

        mapStudents= studentService.addStudentWithSubjects(students, subjects, mapStudents, "Afrodita");

        System.out.println("map of <Students> with new user");
        mapStudents.forEach((K,V) -> System.out.println("key: "+ K + " value: " + V));

        Student student = students.get(ThreadLocalRandom.current().nextInt(0, students.size()));

        String newSubject= "history";

        System.out.println("\nadd a new subject: <" + newSubject +"> for the student: " + student);

        mapStudents=
                  studentService.addSubjectToStudent(
                          student,
                          mapStudents,
                          newSubject,
                          subjects);

        mapStudents.forEach((K,V) -> System.out.println("key: "+ K + " value: " + V));

        studentService.dleteStudent(student, students, mapStudents);

        System.out.println("\nafter deleting of the student: " + student);
        System.out.println("students: " + students);
        mapStudents.forEach((K,V) -> System.out.println("key: "+ K + " value: " + V));

        Subject subject= subjects.stream()
                .filter(s -> newSubject.equals(s.getName()))
                .findAny()
                .orElse(null);

        List<Student> someStudents = new ArrayList<>();
        someStudents.add(students.get(0));
        someStudents.add(students.get(students.size() -1));
        
        mapStudents= studentService.addSubjectToSomeStudents(
                someStudents,
                subject,
                mapStudents);

        System.out.println("\n add new Subject to some students");
        mapStudents.forEach((K,V) -> System.out.println("key: "+ K + " value: " + V));

        System.out.println("\n\n");
        List<Student> listStidentsWithSubject= new ArrayList<>();
        for(Student st: students) {
            for(Subject subj: mapStudents.get(st).keySet()) {
                if(subj.getName().equals(newSubject)) {
                    listStidentsWithSubject.add(st);
                }
            }
        }
        System.out.println("students with newSubject"); //.entrySet());
        System.out.println(listStidentsWithSubject);
        student = listStidentsWithSubject.get(ThreadLocalRandom.current().nextInt(0, students.size()-1));

        System.out.println("student to remove subject: " + student);

        studentService.deleteSubjectFromStudent(
                student,
                newSubject,
                mapStudents);

//        mapStudents.forEach((K,V) -> System.out.println("key: "+ K + " value: " + V));
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
