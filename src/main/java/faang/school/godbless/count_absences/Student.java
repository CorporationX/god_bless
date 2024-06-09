package faang.school.godbless.count_absences;

import java.util.ArrayList;
import java.util.HashMap;

public record Student(String name, String faculty, int year) {
    public HashMap<Key, ArrayList<Student>> groupStudentsByFacultyAndYear() {
        HashMap<Key, ArrayList<Student>> studentsGroupedByFacultyAndYear = new HashMap<>();
        return studentsGroupedByFacultyAndYear;
    }
}
