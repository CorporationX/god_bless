package school.faang.bjs250985;

import java.util.List;

public record School(String name, List<Student> students) {

    public int getTotalPoints(List<Student> students) {
        return students.stream()
                .mapToInt(Student::getPoints)
                .sum();
    }
}