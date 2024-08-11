package faang.school.godbless.BJS2_19532;

import java.util.*;

public class Main {

    private static List<Student> students = new ArrayList<>();

    private static Map<Student, Integer> studentToRemove = new HashMap<>();

    public static void main(String[] args) {

        Student student = new Student("Ruslan", "Economy", 4);
        students.add(student);
        students.add(new Student("Dmitriy", "Physics", 3));
        students.add(new Student("Valentina", "Physics", 3));
        students.add(new Student("Darina", "Psychology", 1));

        studentToRemove.put(student, students.indexOf(student));

        addStudent(new Student("Oleg", "Psychology", 1));
        removeStudent("Ruslan", "Economy", 4);
        findStudents("Physics", 3);
        Map<String, List<Student>> studentFaculty = groupStudents(students);
        showAllStudents(studentFaculty);
    }

    public static Map<String, List<Student>> groupStudents(List<Student> students){
        Map<String, List<Student>> studentsDirection = new HashMap<>();
        for (Student student : students){
            studentsDirection.computeIfAbsent(student.getFaculty() + " " + student.getYear(), value -> new ArrayList<>()).add(student);
        }
        return studentsDirection;
    }

    public static void addStudent(Student student){ students.add(student);}

    public static void removeStudent(String name, String faculty, int year){
        Student student = new Student(name, faculty, year);
        int index = studentToRemove.get(student);
        students.remove(index);
    }

    public static void findStudents(String faculty, int year){
        for (Student student : students){
            if (student.getFaculty().equals(faculty) && student.getYear() == year){
                System.out.println(student.getName());;
            }
        }
    }

    public static void showAllStudents(Map<String, List<Student>> studentsForPrint){
        studentsForPrint.forEach((key, value) -> System.out.println(key + " " + value));
    }
}
