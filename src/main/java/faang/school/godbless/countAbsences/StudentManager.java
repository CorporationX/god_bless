package faang.school.godbless.countAbsences;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class StudentManager {
    private final List<Student> students;
    private final Map<PairFacultyYearKey, List<Student>> studentMap;

    public StudentManager() {
        this.students = new ArrayList<>();
        this.studentMap = new HashMap<>();
    }

    public void addStudent(Student student) {
        students.add(student);
        PairFacultyYearKey key = new PairFacultyYearKey(student.getFaculty().getName(), student.getYear());
        studentMap.computeIfAbsent(key, k -> new ArrayList<>()).add(student);
    }

    public void removeStudent(String name, String facultyName, int year) {
        students.removeIf(student ->
            student.getName().equals(name) &&
            student.getFaculty().getName().equals(facultyName) &&
            student.getYear() == year
        );

        PairFacultyYearKey key = new PairFacultyYearKey(facultyName, year);
        List<Student> facultyYearStudents = studentMap.get(key);
        if (facultyYearStudents != null) {
            facultyYearStudents.removeIf(student ->
                student.getName().equals(name)
            );
            if (facultyYearStudents.isEmpty()) {
                studentMap.remove(key);
            }
        }
    }

    public List<Student> findStudentsByFacultyAndYear(String facultyName, int year) {
        PairFacultyYearKey key = new PairFacultyYearKey(facultyName, year);
        return studentMap.getOrDefault(key, Collections.emptyList());
    }

    public Map<PairFacultyYearKey, List<Student>> getStudentsGroupedByFacultiesAndYears() {
        return studentMap;
    }

    public List<Student> getAllStudents() {
        return students;
    }
}
