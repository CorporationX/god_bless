package src.main.java.faang.school.godbless;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    static List<Student> studentList = new ArrayList<>();
    public void addStudent(Student student) {
        studentList.add(student);
    }

    public void removeStudent(String name, String faculty, int year) {
        Student studentToRemove = new Student(name, faculty, year);
        studentList.remove(studentToRemove);
    }


    public List<Student> findStudentsByFacultyAndYear(String faculty, int year) {
        List<Student> students = new ArrayList<>();
        for (Student student : studentList) {
            if (student.getFaculty().equals(faculty) && student.getYear() == year) {
                students.add(student);
            }
        }
        return students;
    }
    public static Map<String, List<Student>> groupStudentsByFacultyAndYear(List<Student> studentList) {
        Map<String, List<Student>> groupedStudents = new HashMap<>();
        for (Student student : studentList) {
            String key = student.getFaculty() + " " + student.getYear();
            if (groupedStudents.containsKey(key)) {
                groupedStudents.get(key).add(student);
            } else {
                List<Student> studentsList = new ArrayList<>();
                studentsList.add(student);
                groupedStudents.put(key, studentsList);
            }
        }

        return groupedStudents;
    }

    public void printStudentsByFacultyAndYear() {
        Map<String, List<Student>> groupedStudents = groupStudentsByFacultyAndYear(studentList);
        for (String key : groupedStudents.keySet()) {
            System.out.println("Факультет и курс: " + key);
            System.out.println("Студенты:");
            List<Student> students = groupedStudents.get(key);
            for (Student student : students) {
                System.out.println("Имя: " + student.getName());
            }
            System.out.println();

        }
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.addStudent(new Student("petya", "istfak", 1));
        main.addStudent(new Student("vasya", "mexfak", 2));
        main.addStudent(new Student("sasha", "itfak", 3));
        main.addStudent(new Student("pasha", "itfak", 3));
        main.addStudent(new Student("sveta", "itfak", 3));
        main.addStudent(new Student("galya", "itfak", 3));
        main.addStudent(new Student("vanya", "himfak", 4));
        System.out.println("add 4 student");
        main.removeStudent("vanya", "himfak", 4);
        System.out.println("delete student");
        main.findStudentsByFacultyAndYear("itfak",3);
        System.out.println("vot_oni");
        groupStudentsByFacultyAndYear(studentList);
        System.out.println("group");
        groupStudentsByFacultyAndYear(studentList);

    }
}
