package countingabsences;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentsService {
    private static List<Student> students = new ArrayList<>();

    public static Map<FacultyAndYear, List<Student>> getStudentsByFacultyAndYear() {
        Map<FacultyAndYear, List<Student>> resultMap = new HashMap<>();
        for (var student : students) {
            FacultyAndYear mapKey = new FacultyAndYear(student.getFaculty(), student.getYear());
            if (resultMap.get(mapKey) != null) {
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
