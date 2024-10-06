package school.faang.counting_absenteeism;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final List<Student> students = new ArrayList<>(List.of(new Student("Aleksey", "IT", 2024),
            new Student("Mikhail", "IT", 2024),
            new Student("Evgeniy", "IT", 2024),
            new Student("Ekaterina", "IT", 2023),
            new Student("Olja", "IT", 2023),
            new Student("Anna", "Botan", 2023),
            new Student("Oleg", "Botan", 2023)));

    public static void main(String[] args) {
        Map<PairOfFacultyAndYear, List<Student>> studentsByDepartmentAndCourse = getMapStudentsByDepartmentAndCourse(students);
        addStudent("Eva", "IT", 2023);
        showAllStudents(studentsByDepartmentAndCourse);
        System.out.println("-----------------------------");
        Map<PairOfFacultyAndYear, List<Student>> studentsByDepartmentAndCourseAfterAdd = getMapStudentsByDepartmentAndCourse(students);
        showAllStudents(studentsByDepartmentAndCourseAfterAdd);
        System.out.println("-----------------------------");
        removeStudent("Eva", "IT", 2023);
        Map<PairOfFacultyAndYear, List<Student>> studentsByDepartmentAndCourseAfterRemove = getMapStudentsByDepartmentAndCourse(students);
        showAllStudents(studentsByDepartmentAndCourseAfterRemove);
        System.out.println("-----------------------------");
        System.out.print("Все студенты: IT 2024: " + searchAllStudentsByFacultyAndCourse("IT", 2024, studentsByDepartmentAndCourseAfterRemove));
    }

    public static Map<PairOfFacultyAndYear, List<Student>> getMapStudentsByDepartmentAndCourse(List<Student> students) {
        Map<PairOfFacultyAndYear, List<Student>> studentsResultMap = new HashMap<>();
        for (Student student : students) {
            PairOfFacultyAndYear key = new PairOfFacultyAndYear(student.getFaculty(), student.getYear());
            studentsResultMap.computeIfAbsent(key, s -> new ArrayList<>()).add(student);
        }
        return studentsResultMap;
    }

    public static void addStudent(String name, String faculty, int year) {
        if (name != null && faculty != null && year > 0) {
            Student student = new Student(name, faculty, year);
            students.add(student);
        } else {
            throw new IllegalArgumentException("Чтобы добавить студента в список, все поля должны быть заполнены");
        }
    }

    public static void removeStudent(String name, String faculty, int year) {
        if (name != null && faculty != null && year > 0) {
            Student student = new Student(name, faculty, year);
            students.remove(student);
        } else {
            throw new IllegalArgumentException("Чтобы удалить студента из списка, все поля должны быть заполнены");
        }
    }

    public static List<Student> searchAllStudentsByFacultyAndCourse(String faculty, int course, Map<PairOfFacultyAndYear, List<Student>> studentsByDepartmentAndCourse) {
        PairOfFacultyAndYear keyStudents = new PairOfFacultyAndYear(faculty, course);
        return studentsByDepartmentAndCourse.get(keyStudents);
    }

    public static void showAllStudents(Map<PairOfFacultyAndYear, List<Student>> studentsByDepartmentAndCourse) {
        for (Map.Entry<PairOfFacultyAndYear, List<Student>> entry : studentsByDepartmentAndCourse.entrySet()) {
            List<Student> students = entry.getValue();
            PairOfFacultyAndYear key = entry.getKey();
            System.out.printf("Все студенты с факультета %s и курса %d%n", key.faculty(), key.year());
            for (Student student : students) {
                System.out.print(student.getName() + " ");
            }
            System.out.println();
        }
    }

}
