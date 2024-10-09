package countingabsences;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static List<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        addNewStudent(new Student("student1", "faculty1", 1));
        addNewStudent(new Student("student2", "faculty1", 1));
        addNewStudent(new Student("student3", "faculty2", 2));
        addNewStudent(new Student("student4", "faculty3", 3));
        addNewStudent(new Student("student5", "faculty3", 3));

        printAllStudentsByFacultyAndYear();
        removeStudent("student4", "faculty3", 3);
        System.out.println(getStudentsByFacultyAndYear("faculty3", 3));
        printAllStudentsByFacultyAndYear();
    }

    public static Map<String, List<Student>> getStudentsByFacultyAndYear() {
        Map<String, List<Student>> resultMap = new HashMap<>();
        for (var student : students) {
            String mapKey = student.getFaculty() + " " + student.getYear();
            if (resultMap.containsKey(mapKey)) {
                resultMap.get(mapKey).add(student);
            } else {
                List<Student> newStudentByFacultyAndYear = new ArrayList<>();
                newStudentByFacultyAndYear.add(student);
                resultMap.put(mapKey, newStudentByFacultyAndYear);
            }
        }
        return resultMap;
    }

    public static List<Student> getStudentsByFacultyAndYear(String faculty, int year) {
        List<Student> resultList = new ArrayList<>();
        for (var student : students) {
            if (student.getFaculty().equals(faculty) && student.getYear() == year) {
                resultList.add(student);
            }
        }
        return resultList;
    }

    public static void printAllStudentsByFacultyAndYear() {
        for (var studentEntry : getStudentsByFacultyAndYear().entrySet()) {
            System.out.println(studentEntry.getKey() + " " + studentEntry.getValue());
        }
    }

    public static void addNewStudent(Student student) {
        students.add(student);
    }

    public static void removeStudent(String name, String faculty, int year) {
        students.remove(new Student(name, faculty, year));
    }
}
