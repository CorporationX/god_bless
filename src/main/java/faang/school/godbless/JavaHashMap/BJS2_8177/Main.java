package faang.school.godbless.JavaHashMap.BJS2_8177;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Леха", "Физика", 1));
        students.add(new Student("Дима", "Математика", 2));
        students.add(new Student("Катя", "Биология", 2));
        students.add(new Student("Петя", "Математика", 3));
        students.add(new Student("Макс", "Математика", 2));
        students.add(new Student("Вика", "Математика", 2));

        addStudent(students, new Student("Ирина", "Биология", 1));
        removeStudent(students, "Дима", "Математика", 2);
        List<Student> studentsYear2 = findStudentsByFacultyAndYear(students, "Математика", 2);
        System.out.println("Студенты факультета Математика 2 курса: " + studentsYear2);
        System.out.println();
        studentList(students);
        System.out.println();
        Map<String, List<Student>> groupedStudents = groupStudentsByFacultyAndYear(students);
        printAllStudent(groupedStudents);
    }
    public static Map<String, List<Student>> groupStudentsByFacultyAndYear(List<Student> students) {
        Map<String, List<Student>> map = new HashMap<>();
        for (Student student : students) {
            String key = student.getFaculty() + " - " + student.getYear();
                map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(student);
        }
        return map;
    }

    public static void addStudent(List<Student> students, Student student) {
        students.add(student);
    }

    public static void removeStudent(List<Student> students, String name, String faculty, int year) {
        students.removeIf(student -> student.getName().equals(name) && student.getFaculty().equals(faculty) && student.getYear() == year);
    }

    public static List<Student> findStudentsByFacultyAndYear(List<Student> students, String faculty, int year) {
        List<Student> result = new ArrayList<>();
        for (Student student : students) {
            if (student.getFaculty().equals(faculty) && student.getYear() == year) {
                result.add(student);
            }
        }
        return result;
    }
    public static void printAllStudent(Map<String, List<Student>> studentList){
        for (Map.Entry<String, List<Student>> entry : studentList.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
    public static void studentList(List<Student> studentList){
        for (Student student : studentList){
            System.out.println(student);
        }
    }
}
