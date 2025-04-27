package school.faang.bjs2_74874;

import java.util.ArrayList;
import java.util.List;


public record School(String name, List<Student> students) {
    public School {
        students = students != null ? students : new ArrayList<>();
    }

    public int getTotalPoints() {
        return students.stream()
                .mapToInt(Student::getPoints)
                .sum();
    }
}
