package ru.kraiush.BJS2_32409;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final Map<StudyInfo, List<Student>> FACULTIES = new HashMap<>();

    private static Map<StudyInfo, List<Student>> transformListToMap(List<Student> students) {
        for (Student student : students) {
            addStudentInFaculty(student);
        }
        return FACULTIES;
    }

    private static void addStudentInFaculty(Student student) {
        FACULTIES.computeIfAbsent(student.getStudyInfo(), k -> new ArrayList<>()).add(student);
    }

    private static void removeStudentFromFaculty(String name, String faculty, int year) {
        StudyInfo studyInfo = new StudyInfo(faculty, year);
        Student student = new Student(name, studyInfo);
        List<Student> studentsList = FACULTIES.get(studyInfo);
        studentsList.remove(student);
        FACULTIES.put(studyInfo, studentsList);
    }

    private static void getStudentsOfFaculty(String faculty, int year) {
        StudyInfo studyInfo = new StudyInfo(faculty, year);
        System.out.println(FACULTIES.get(studyInfo));
    }

    private static void getStudentsGroupedByFacultiesAndCourses() {
        for (Map.Entry<StudyInfo, List<Student>> entry : FACULTIES.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        StudyInfo studyInfo_1 = new StudyInfo("Computer Science", 1);
        StudyInfo studyInfo_2 = new StudyInfo("Computer Science", 2);
        StudyInfo studyInfo_3 = new StudyInfo("Computer Science", 3);
        StudyInfo studyInfo_4 = new StudyInfo("Computer Science", 4);
        StudyInfo studyInfo_5 = new StudyInfo("Marketing", 1);
        StudyInfo studyInfo_6 = new StudyInfo("Marketing", 2);
        StudyInfo studyInfo_7 = new StudyInfo("Marketing", 3);
        StudyInfo studyInfo_8 = new StudyInfo("Marketing", 4);
        StudyInfo studyInfo_9 = new StudyInfo("Psychology", 1);
        StudyInfo studyInfo_10 = new StudyInfo("Psychology", 2);

        Student student_1 = new Student("James Anderson", studyInfo_1);
        Student student_2 = new Student("Emily Davis", studyInfo_1);
        Student student_3 = new Student("Michael Thompson", studyInfo_2);
        Student student_4 = new Student("Jessica Harris ", studyInfo_2);
        Student student_5 = new Student("David White", studyInfo_3);
        Student student_6 = new Student("Sarah Wilson", studyInfo_3);
        Student student_7 = new Student("John Johnson", studyInfo_4);
        Student student_8 = new Student("Olivia Martin", studyInfo_4);
        Student student_9 = new Student("Daniel Roberts", studyInfo_5);
        Student student_10 = new Student("Emma Clark", studyInfo_5);
        Student student_11 = new Student("Christopher Miller", studyInfo_6);
        Student student_12 = new Student("Sophia Moore", studyInfo_6);
        Student student_13 = new Student("Matthew Taylor", studyInfo_7);
        Student student_14 = new Student("Isabella Brown", studyInfo_7);
        Student student_15 = new Student("Joshua Lee", studyInfo_8);
        Student student_16 = new Student("Megan Walker", studyInfo_8);
        Student student_17 = new Student("Andrew Hall", studyInfo_9);
        Student student_18 = new Student("Chloe Adams", studyInfo_9);

        List<Student> students = new ArrayList<>();
        students.add(student_1);
        students.add(student_2);
        students.add(student_3);
        students.add(student_4);
        students.add(student_5);
        students.add(student_6);
        students.add(student_7);
        students.add(student_8);
        students.add(student_9);
        students.add(student_10);
        students.add(student_11);
        students.add(student_12);
        students.add(student_13);
        students.add(student_14);
        students.add(student_15);
        students.add(student_16);
        students.add(student_17);
        students.add(student_18);

        transformListToMap(students);
        addStudentInFaculty(new Student("Benjamin Scott", studyInfo_10));
        removeStudentFromFaculty("James Anderson", "Computer Science", 1);
        getStudentsOfFaculty("Marketing", 4);
        getStudentsGroupedByFacultiesAndCourses();
    }
}
