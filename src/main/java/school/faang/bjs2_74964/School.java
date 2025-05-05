package school.faang.bjs2_74964;

import java.util.List;

public record School(String name, List<Student> students) {
    public int getTotalPoints() {
        return students.stream()
                .map(Student::getPoints)
                .mapToInt(i -> i)
                .sum();
    }
}