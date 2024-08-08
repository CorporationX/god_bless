package Mathew;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    static List<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        Student student1 = new Student("Ван Ванов Даркхолмов", "Факультет информатики", 2);
        Student student2 = new Student("Мария Петрова", "Факультет экономики", 3);
        Student student3 = new Student("Дмитрий Сергеев", "Факультет физики", 1);
        students.add(student1);
        students.add(student2);
        students.add(student3);
        System.out.println(facultyYearOfStudents(students).toString());
        System.out.println(listOfAllStudentsFacultyAndYear().toString());
        addStudent("Mitio Kanai", "Japanese History", 1);
        removeStudent("Дмитрий Сергеев");
        System.out.println(facultyYearOfStudents(students).toString());

    }

    public static HashMap<Pair, List<Student>> facultyYearOfStudents(List<Student> list) {
        HashMap<Pair, List<Student>> hashMap = new HashMap<>();
        for (Student student : list) {
            Pair pair = new Pair(student.getFaculty(), student.getYear());
            hashMap.computeIfAbsent(pair, k -> new ArrayList<>()).add(student);
        }
        return hashMap;
    }

    public static void addStudent(String name, String faculty, int year) {
        students.add(new Student(name, faculty, year));
    }

    public static void removeStudent(String name) {
        students.removeIf(student -> student.getName().equals(name));
    }

    public static List<Student> searchStudents(String faculty, int year) {
        List<Student> foundStudents = new ArrayList<>();

        for (Student student : students) {
            if (student.getFaculty().equals(faculty) && student.getYear() == year) {
                foundStudents.add(student);
            }
        }
        return foundStudents;
    }

    //вывод списка всех студентов сгруппированных по факультетам и курсам
    public static Map<Pair, List<Student>> listOfAllStudentsFacultyAndYear() {
        Map<Pair, List<Student>> hashMap_StudentsFacultyAndYear = new HashMap<>();
        for (Student student : students) {
            Pair pair = new Pair(student.getFaculty(), student.getYear());
            hashMap_StudentsFacultyAndYear.computeIfAbsent(pair, k -> new ArrayList<>()).add(student);
        }
        return hashMap_StudentsFacultyAndYear;
    }
}



