package ru.kraiush.BJS2_20267;

import java.util.ArrayList;
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

        for (Map.Entry<Subject, Integer> item : mapStudents.get(student).entrySet()) {
            if (item.getKey() != null && item.getKey().getName().equals(newSubject)) {
//                System.out.println("|item.getKey().getId(): " + item.getKey().getId());
//                System.out.println("item.getKey().getName(): " + item.getKey().getName());
                mapStudents.get(student).remove(item.getKey());
                break;
            }
        }
        return mapStudents;
    }

    public List<Student> listStidentsWithSubject(List<Student> students, Map<Student, Map<Subject, Integer>> mapStudents, String subject) {

        List<Student> listStidentsWithSubject= new ArrayList<>();

        for (Student st : students) {
            for (Subject subj : mapStudents.get(st).keySet()) {
                if (subj.getName().equals(subject)) {
                    listStidentsWithSubject.add(st);
                }
            }
        }
        return listStidentsWithSubject;
    }

    public void deleteStudent(Student student, List<Student> students, Map<Student, Map<Subject, Integer>> mapStudents) {

        students.removeIf(s -> s.equals(student));
        mapStudents.remove(student);
    }
}


