package faang.school.godbless.multithreading_2.tournament;

import java.util.List;

public record School(String name, List<Student> team) {

    public int getTotalPoints() {
        return team.stream()
                .map(Student::getPoints)
                .reduce(Integer::sum)
                .orElse(0);
    }
}
