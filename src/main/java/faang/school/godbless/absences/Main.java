package faang.school.godbless.absences;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Student> studentsList = new ArrayList<>();

        Student student1 = new Student("Alice Johnson", "Computer Science", 2);
        Student student2 = new Student("Bob Smith", "Electrical Engineering", 3);
        Student student3 = new Student("Carol White", "Mechanical Engineering", 4);
        Student student4 = new Student("David Brown", "Civil Engineering", 2);
        Student student5 = new Student("Eve Davis", "Computer Science", 1);
        Student student6 = new Student("Frank Wilson", "Electrical Engineering", 3);
        Student student7 = new Student("Grace Moore", "Mechanical Engineering", 2);
        Student student8 = new Student("Hank Taylor", "Civil Engineering", 4);
        Student student9 = new Student("Ivy Anderson", "Computer Science", 2);
        Student student10 = new Student("Jack Thomas", "Electrical Engineering", 4);

        Collections.addAll(studentsList, student1, student2, student3, student4, student5, student6, student7, student8, student9, student10);

        System.out.println(groupStudents(studentsList));

    }

    public static HashMap<FacultyYearPair, List<Student>> groupStudents(List<Student> studentsList){
        HashMap<FacultyYearPair, List<Student>> result = new HashMap<>();

        for (Student student : studentsList) {
            FacultyYearPair key = new FacultyYearPair(student.getFaculty(), student.getYear());
            result.computeIfAbsent(key, k -> new ArrayList<>()).add(student);
        }
        return result;
    }

    public static void addStudent(List<Student> studentsList, Student student) {
        if (!studentsList.contains(student)){
            studentsList.add(student);
        }
        else {
            throw new IllegalArgumentException("This student already exists");
        }
    }

    public static void deleteStudent(List<Student> studentsList, String name, String faculty, int year) {
        Student student = new Student(name, faculty, year);
        if (studentsList.contains(student)) {
            studentsList.remove(student);
        } else {
            throw new IllegalArgumentException("There is no student with such parameters");
        }
    }
}
