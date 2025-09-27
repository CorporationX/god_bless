package school.faang.bjs2_92896;

import java.util.List;

public record School(String name, List<Student> students) {

    public int getTotalPoints() {
        return students.stream()
                .mapToInt(Student::getPoints)
                .sum();
    }
}
