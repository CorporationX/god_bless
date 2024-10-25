package school.faangSprint4.t06;

import java.util.List;

public record School(String name, List<Student> team) {

    public int getTotalPoints() {
        return team.stream()
                .mapToInt(Student::getPoints)
                .sum();
    }
}