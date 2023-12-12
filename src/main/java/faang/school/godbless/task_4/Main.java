package faang.school.godbless.task_4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static List<Student> studentList = createStudents();

    public static void main(String[] args) {


        System.out.println();

        Student newStudent = new Student("Ivan Serov", "Economy", "Economist");
        Student searchStudent = new Student("Alexey Shelehov", "Economy", "Creditor");

        printStudentsByFacultyAndCourse();


    }

    static List<Student> createStudents() {
        return Arrays.asList(
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
        );
    }

    public static void addStudent(Student student) {
        studentList.add(student);
    }

    public static void removeStudent(String name, String faculty, String course) {
        for (Student student : studentList) {
            if (student.getName().equals(name) && student.getFaculty().equals(faculty) && student.getCourse().equals(course)) {
                studentList.remove(student);
            }
        }
    }

    public static List<Student> searchStudent(String faculty, String course) {
        List<Student> students = new ArrayList<>();
        for (Student student : studentList) {
            if (student.getFaculty().equals(faculty) && student.getCourse().equals(course)) {
                students.add(student);
            }
        }
        return students;
    }

    public static void printStudentsByFacultyAndCourse() {
        getStudentsMap().forEach((stringStringEntry, studentList1) -> {
            System.out.println(stringStringEntry.getKey() + " " + stringStringEntry.getValue() + " : '\n'" + studentList1);
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
