package faang.school.godbless.hashMap.task_4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static List<Student> studentList = new ArrayList<>(Arrays.asList(
            new Student("Ivan Ivanov", "Economy", "Economist"),
            new Student("Sergey Petrov", "Economy", "Economist"),

            new Student("Ivan Sibirko", "Economy", "Creditor"),
            new Student("Alexey Shelehov", "Economy", "Creditor"),

            new Student("Ruslan Galimov", "Jurisprudence", "Lawyer"),
            new Student("Anastasia Belikova", "Jurisprudence", "Lawyer"),

            new Student("Nariman Usypov", "Jurisprudence", "Judge"),
            new Student("Kirill Sobolev", "Jurisprudence", "Judge"),

            new Student("Pavel Volya", "Jurisprudence", "Judge"),
            new Student("Artur Pirojkov", "Jurisprudence", "Judge")
    ));

    public static void main(String[] args) {

        System.out.println();

        Student newStudent = new Student("Ivan Serov", "Economy", "Economist");

        printStudentsByFacultyAndCourse();
        System.out.println();

        addStudent(newStudent);

        printStudentsByFacultyAndCourse();
        System.out.println();

        removeStudent("Ruslan Galimov", "Jurisprudence", "Lawyer");

        printStudentsByFacultyAndCourse();
        System.out.println();

        System.out.println(searchStudents("Jurisprudence", "Judge"));

    }

    public static void addStudent(Student student) {
        studentList.add(student);
    }

    public static void removeStudent(String name, String faculty, String course) {
        Student removeStudent = null;
        for (Student student : studentList) {
            if (student.getName().equals(name) && student.getFaculty().equals(faculty) && student.getCourse().equals(course)) {
                removeStudent = student;
                break;
            }
        }
        if (removeStudent != null) {
            studentList.remove(removeStudent);
        }
    }

    public static List<Student> searchStudents(String faculty, String course) {
        List<Student> students = new ArrayList<>();
        for (Student student : studentList) {
            if (student.getFaculty().equals(faculty) && student.getCourse().equals(course)) {
                students.add(student);
            }
        }
        return students;
    }

    public static void printStudentsByFacultyAndCourse() {
        getStudentsMap().forEach((stringStringEntry, studentList) -> {
            System.out.println(stringStringEntry.getKey() + " " + stringStringEntry.getValue() + " : '\n'" + studentList);
        });
    }

    public static Map<Map.Entry<String, String>, List<Student>> getStudentsMap() {
        Map<Map.Entry<String, String>, List<Student>> mapStudentsOnCourse = new HashMap<>();

        List<Student> studentsOnCourse;

        for (Student st : studentList) {

            String faculty = st.getFaculty();
            String course = st.getCourse();

            Map.Entry<String, String> mapEntry = Map.entry(faculty, course);

            studentsOnCourse = mapStudentsOnCourse.getOrDefault(mapEntry, new ArrayList<>());

            studentsOnCourse.add((st));

            mapStudentsOnCourse.put(mapEntry, studentsOnCourse);
        }
        return mapStudentsOnCourse;
    }
}
