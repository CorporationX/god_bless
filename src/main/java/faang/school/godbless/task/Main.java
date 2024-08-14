package faang.school.godbless.task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static List<Student> studentList = new ArrayList<>();

    public static void main(String[] args) {

        studentList.add(new Student("name", "faculty", 1));
        studentList.add(new Student("name1", "faculty", 1));
        studentList.add(new Student("name2", "faculty2", 2));
        studentList.add(new Student("name3", "faculty2", 2));
        studentList.add(new Student("name4", "faculty3", 3));

        Map<FacultyYearKey, List<Student>> map = filterStudents(studentList);
        printAllStudents(map);

        addStudent(new Student("Name", "Faculty", 1));
        System.out.println(studentList.size());

        removeStudent(new Student("Name", "Faculty", 1));
        System.out.println(studentList.size());

        System.out.println(findAllByFilter(new FacultyYearKey("faculty", 1)));

        printAllStudents(map);
    }

    public static Map<FacultyYearKey, List<Student>> filterStudents(List<Student> studentList) {
        Map<FacultyYearKey, List<Student>> FacultyYearKeyStudentMap = new HashMap<>();

        for (Student student : studentList) {
            FacultyYearKey facultyYearKey = new FacultyYearKey(student.getFaculty(), student.getYear());

            if (FacultyYearKeyStudentMap.containsKey(facultyYearKey)) {
                FacultyYearKeyStudentMap.get(facultyYearKey).add(student);
            } else {
                FacultyYearKeyStudentMap.put(facultyYearKey, new ArrayList<>(List.of(student)));
            }
        }

        return FacultyYearKeyStudentMap;
    }

    public static void addStudent(Student student) {
        if (!isValidData(student)) {
            System.out.println("Студент не может быть null!");
        } else {
            studentList.add(student);
        }
    }

    public static void removeStudent(Student student) {
        if (!isValidData(student)) {
            System.out.println("Студент не может быть null!");
        } else {
            studentList.remove(student);
        }
    }

    public static List<Student> findAllByFilter(FacultyYearKey facultyYearKey) {
        List<Student> students = new ArrayList<>();

        for (Student student : studentList) {
            if (student.getFaculty().equals(facultyYearKey.getFaculty()) && student.getYear() == facultyYearKey.getYear()) {
                students.add(student);
            }
        }

        return students;
    }

    public static void printAllStudents(Map<FacultyYearKey, List<Student>> map) {
        for (Map.Entry<FacultyYearKey, List<Student>> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }

    private static boolean isValidData(Student student) {
        return student != null && student.getName() != null && !student.getName().isBlank();
    }
}
