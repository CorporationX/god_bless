package faang.school.godbless.students;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Data
public class StudentOrganizer {

    private final Map<FacultyYearKey, List<Student>> organizedMap;

    public StudentOrganizer() {
        this.organizedMap = new HashMap<>();
    }

    public void organizeStudentsByFacultyToYear(List<Student> students) {
        for (Student student : students) {
            FacultyYearKey facultyYearKey = new FacultyYearKey(student.faculty(), student.year());
            this.organizedMap.computeIfAbsent(facultyYearKey, k -> new ArrayList<>()).add(student);
        }
    }

    public void addNewStudent(Student student) {
        Objects.requireNonNull(student);
        FacultyYearKey facultyYearKey = new FacultyYearKey(student.faculty(), student.year());
        this.organizedMap.computeIfPresent(facultyYearKey, (key, list) -> {
            list.add(student);
            return list;
        });
    }

    public void removeStudent(Student student) {
        Objects.requireNonNull(student);
        FacultyYearKey facultyYearKey = new FacultyYearKey(student.faculty(), student.year());
        this.organizedMap.computeIfPresent(facultyYearKey, (key, list) -> {
            list.remove(student);
            return list;
        });
    }

    public void printOrganizedMap() {
        this.organizedMap.forEach((k, v) -> System.out.println(k + ": " + v));
    }

    public void printSingleGroup(FacultyYearKey facultyYearKey) {
        System.out.println(this.organizedMap.get(facultyYearKey));
    }
}
