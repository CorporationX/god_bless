package school.faang.bjs2_32590;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class StudentManager {
    public static Map<FacultyYearPair, List<Student>> groupStudentsByFacultyAndYear(List<Student> students) {
        HashMap<FacultyYearPair, List<Student>> groupedStudentsByFacultyAndYear = new HashMap<>();
        for (Student student : students) {
            FacultyYearPair facultyYearPairCurrentStudent = student.getFacultyYearPair();
            if (!(groupedStudentsByFacultyAndYear.containsKey(facultyYearPairCurrentStudent))) {
                List<Student> groupStudentByFacultyAndYear = allocationToCurrentGroup(students, facultyYearPairCurrentStudent);
                groupedStudentsByFacultyAndYear.put(facultyYearPairCurrentStudent, groupStudentByFacultyAndYear);
            } else {
                List<Student> groupStudentByFacultyAndYear = groupedStudentsByFacultyAndYear.get(facultyYearPairCurrentStudent);
                if (!(groupStudentByFacultyAndYear.contains(student))) {
                    groupStudentByFacultyAndYear.add(student);
                }
            }
        }
        return groupedStudentsByFacultyAndYear;
    }

    public static void addStudentToList(Student student, List<Student> students) {
        if (!(students.contains(student))) {
            students.add(student);
        }
    }

    public static void removeStudent(String name, String faculty, int year, List<Student> students) {
        Student student = new Student(name, faculty, year);
        students.remove(student);
    }

    private static List<Student> allocationToCurrentGroup(List<Student> students, FacultyYearPair facultyYearPairCurrentStudent) {
        ArrayList<Student> groupStudentByFacultyAndYear = new ArrayList<>();
        for (Student studentForGroup : students) {
            if (Objects.equals(facultyYearPairCurrentStudent, studentForGroup.getFacultyYearPair())) {
                groupStudentByFacultyAndYear.add(studentForGroup);
            }
        }
        return groupStudentByFacultyAndYear;
    }

}
