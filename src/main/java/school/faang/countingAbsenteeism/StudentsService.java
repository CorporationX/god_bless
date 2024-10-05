package school.faang.countingAbsenteeism;

import java.util.*;

public class StudentsService {

    List<Student> students = new ArrayList<>();

    private Map<FacultyYearMapping, List<Student>> groupStudents(List<Student> students) {
        Map<FacultyYearMapping, List<Student>> map = new HashMap<>();

        for (Student student : students) {
            FacultyYearMapping newFacultyInfo = new FacultyYearMapping(student.getFaculty(), student.getYear());
            map.computeIfAbsent(newFacultyInfo, k -> new ArrayList<>()).add(student);
        }
        return map;
    }

    public void addNewStudent(String name, String faculty, int year) {
        students.add(new Student(name, faculty, year));
    }

    public void removeStudent(String name, String faculty, int year) {
        students.remove(new Student(name, faculty, year));
    }

    public String showStudentsByFacultyAndYear(String faculty, int year) {
        Map<FacultyYearMapping, List<Student>> map = groupStudents(students);

        StringBuilder sb = new StringBuilder();
        sb.append(faculty);
        sb.append("::");
        sb.append(year);
        sb.append(" -> ");
        sb.append("\n");
        for (Student student : map.get(new FacultyYearMapping(faculty, year))) {
            sb.append(student.toString());
            sb.append("\n");
        }
        return sb.toString();
    }

    public String showAllStudentsByFacultyAndYear() {
        Map<FacultyYearMapping, List<Student>> map = groupStudents(students);

        StringBuilder sb = new StringBuilder();

        for (Map.Entry<FacultyYearMapping, List<Student>> entry : map.entrySet()) {
            sb.append(showStudentsByFacultyAndYear(entry.getKey().getFaculty(), entry.getKey().getYear()));
            sb.append("\n");
        }

        return sb.toString();
    }
}

