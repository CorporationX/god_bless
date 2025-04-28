package school.faang.async.triwizard_tournament;

import java.util.List;

public record School(String name, List<Student> team) {

    public int getTotalPoints() {
        return team.stream().mapToInt((student) -> student.getPoints().get()).sum();
    }
}
