package school.faang.task50717;

import java.util.List;

public record School(String name,
                     List<Student> team) {

    public int getTotalPoints() {
        return team.stream()
                .mapToInt(Student::getTotalPoints)
                .sum();
    }
}
