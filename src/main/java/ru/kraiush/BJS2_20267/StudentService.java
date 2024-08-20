package ru.kraiush.BJS2_20267;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class StudentService {

    public List<Student> newStudent(List<Student> students, String name) {

        if (students == null || name == null || name.trim().isEmpty()) {
            return null;
        }
        students.add(new Student(students.size() + 1, name));
        return students;
    }

    public Map<Student, Map<Subject, Integer>> addStudentWithSubjects(
            List<Student> students,
            List<Subject> subjects,
            Map<Student, Map<Subject, Integer>> mapStudents,
            String name) {

        Student student = new Student(students.size() + 1, name);
        students.add(student);

        Map<Subject, Integer> map = new HashMap<>();
        for (Subject subject : subjects) {
            Integer random_Int = ThreadLocalRandom.current().nextInt(1, 10);
            map.put(subject, random_Int);
        }
        mapStudents.put(student, map);
        return mapStudents;
    }

    public Map<Student, Map<Subject, Integer>> addSubjectToStudent(
            Student student,
            Map<Student, Map<Subject, Integer>> mapStudents,
            String name,
            List<Subject> subjects) {

        Subject newSubject = new Subject(subjects.size() + 1, name);
        subjects.add(newSubject);

        Map<Subject, Integer> mapStudent = mapStudents.get(student);
        mapStudent.put(newSubject, ThreadLocalRandom.current().nextInt(1, 10));

        mapStudents.put(student, mapStudent);
        return mapStudents;
    }

    public Map<Student, Map<Subject, Integer>> initializeStudentsWithSubjects(List<Student> students, List<Subject> subjects) {

        Map<Student, Map<Subject, Integer>> mapStudents = new HashMap<>();

        for (Student student : students) {
            Map<Subject, Integer> map = new HashMap<>();
            for (Subject subject : subjects) {
                Integer random_Int = ThreadLocalRandom.current().nextInt(1, 10);
                map.put(subject, random_Int);
            }
            mapStudents.put(student, map);
        }
        return mapStudents;
    }

    public Map<Student, Map<Subject, Integer>> addSubjectToSomeStudents(
            List<Student> students,
            Subject subject,
            Map<Student, Map<Subject, Integer>> mapStudents) {

        for (Student student : students) {
            Map<Subject, Integer> map = mapStudents.get(student);
            map.put(subject, ThreadLocalRandom.current().nextInt(1, 10));
            mapStudents.put(student, map);
        }
        return mapStudents;
    }

    public Map<Student, Map<Subject, Integer>> deleteSubjectFromStudent(
            Student student,
            String newSubject,
            Map<Student, Map<Subject, Integer>> mapStudents) {

        System.out.println("st: " + student);

        System.out.println("\nEntrySet() fro user with newSubject: " + mapStudents.get(student).keySet());

        for (Subject subj : mapStudents.get(student).keySet()) {
            if (subj.getName().equals(newSubject)) {
                System.out.println("subj.getId(): " + subj.getId());
                mapStudents.get(student).keySet().remove(subj.getId());
            }
        }
        return mapStudents;
    }

    public void dleteStudent(Student student, List<Student> students, Map<Student, Map<Subject, Integer>> mapStudents) {

        students.removeIf(s -> s.equals(student));
        mapStudents.remove(student);
    }
}
