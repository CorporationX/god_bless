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
        for (Map.Entry<FacultyYearKey, List<Student>> entry : organizedMap.entrySet()) {
            FacultyYearKey facultyYearKey = entry.getKey();
        }
    }

    public void printOrganizedMap() {
        this.organizedMap.forEach((k, v) -> System.out.println(k + ": " + v));
    }
}
