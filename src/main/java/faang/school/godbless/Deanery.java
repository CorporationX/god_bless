package faang.school.godbless;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Deanery {
    List<Student> students = new ArrayList<>();
    Map<FacultyYearInfo, List<Student>> cachedGroupStudentsByFacultyAndYear;

    Deanery(List<Student> students) {
        students.forEach(this::addStudent);
    }

    public void addStudent(Student newStudent) {
        students.add(newStudent);

        invalidateCache();
    }

    public void removeStudent(String name, String faculty, int year) {
        students.removeIf(student -> student.getName().equals(name) && student.getFaculty().equals(faculty) && student.getYear() == year);

        invalidateCache();
    }

    public List<Student> getStudentsByFacultyAndYear(FacultyYearInfo info) {
        return groupStudentsByFacultyAndYear().get(info);
    }

    public Map<FacultyYearInfo, List<Student>> groupStudentsByFacultyAndYear() {
        if (cachedGroupStudentsByFacultyAndYear != null) {
            return cachedGroupStudentsByFacultyAndYear;
        }

        Map<FacultyYearInfo, List<Student>> groupedStudents = new HashMap<>();

        for (Student student : students) {
            FacultyYearInfo key = new FacultyYearInfo(student.getFaculty(), student.getYear());
            groupedStudents.computeIfAbsent(key, k -> new ArrayList<>()).add(student);
        }

        cachedGroupStudentsByFacultyAndYear = groupedStudents;

        return groupedStudents;
    }

    public void invalidateCache() {
        cachedGroupStudentsByFacultyAndYear = null;
    }
}
