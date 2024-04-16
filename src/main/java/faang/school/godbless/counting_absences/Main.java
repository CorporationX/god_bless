package faang.school.godbless.counting_absences;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        Student student1 = new Student("Alex", "Psychology", 1);
        Student student3 = new Student("Lana", "Psychology", 1);
        Student student4 = new Student("John", "Psychology", 3);
        Student student5 = new Student("Ben", "Informatics", 2);
        Student student2 = new Student("David", "Informatics", 2);
        Student student6 = new Student("Jane", "Physics", 4);
        Student student7 = new Student("Katya", "Physics", 4);

        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        students.add(student5);
        students.add(student6);
        students.add(student7);

        HashMap<DoubleKey, List<Student>> facultyYearStudentMap = addStudents(students);

        printStudentsByCourseAndFaculty(facultyYearStudentMap);

        removeStudent("Alex", "Psychology", 1, facultyYearStudentMap);

        addStudent(new Student("Soslan", "Psychology", 1), facultyYearStudentMap);

        System.out.println(searchStudentsByFacultyAndYear("Psychology", 1, facultyYearStudentMap));

        printStudentsByCourseAndFaculty(facultyYearStudentMap);
    }

    public static HashMap<DoubleKey, List<Student>> addStudents(List<Student> students) {
        HashMap<DoubleKey, List<Student>> facultyYearStudentMap = new HashMap<>();
        for (Student student : students) {
            String faculty = student.getFaculty();
            int year = student.getYear();
            DoubleKey doubleKey = new DoubleKey(faculty, year);
            if (facultyYearStudentMap.containsKey(doubleKey)) {
                facultyYearStudentMap.get(doubleKey).add(student);
            } else {
                List<Student> studentList = new ArrayList<>();
                studentList.add(student);
                facultyYearStudentMap.put(doubleKey, studentList);
            }
        }
        return facultyYearStudentMap;
    }

    public static void addStudent(Student student, HashMap<DoubleKey, List<Student>> facultyYearStudentMap) {
        DoubleKey doubleKey = new DoubleKey(student.getFaculty(), student.getYear());
        if (facultyYearStudentMap.containsKey(doubleKey)) {
            facultyYearStudentMap.get(doubleKey).add(student);
        } else {
            List<Student> studentList = new ArrayList<>();
            studentList.add(student);
            facultyYearStudentMap.put(doubleKey, studentList);
        }
    }

    public static void removeStudent(String name, String faculty, int year, HashMap<DoubleKey, List<Student>> facultyYearStudentMap) {
        DoubleKey doubleKey = new DoubleKey(faculty, year);
        if (facultyYearStudentMap.containsKey(doubleKey)) {
            List<Student> students = facultyYearStudentMap.get(doubleKey);
            students.removeIf(student -> student.getName().equals(name));

            System.out.println("Студент " + name + " удален из списка для факультета " + faculty + " и курса " + year + ".");
        } else {
            System.out.println("Факультет " + faculty + " и курс " + year + " не найдены в списке.");
        }
    }

    public static List<Student> searchStudentsByFacultyAndYear(String faculty, int year, HashMap<DoubleKey, List<Student>> facultyYearStudentMap) {
        List<Student> students = new ArrayList<>();
        DoubleKey doubleKey = new DoubleKey(faculty, year);
        if (facultyYearStudentMap.containsKey(doubleKey)) {
            students = facultyYearStudentMap.get(doubleKey);
        }

        return students;
    }

    public static void printStudentsByCourseAndFaculty(HashMap<DoubleKey, List<Student>> facultyYearStudentMap) {
        facultyYearStudentMap.forEach((key, studentList) -> {
            System.out.println("Ключ: " + key);
            System.out.println("Студенты:");
            studentList.forEach(System.out::println);
            System.out.println();
        });
    }
}
