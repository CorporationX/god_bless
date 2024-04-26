package faang.school.godbless.async.triwizardTournament;

import java.util.List;

public record School(String name, List<Student> team ) {
    public int getTotalPoints() {
        return team.stream()
                .reduce(0, (totalPoints, student) -> totalPoints + student.getPoints(), Integer::sum);
    }

    public School updatePoints(int reward) {
        team.forEach(student -> student.gainPoints(reward));

        return this;
    }
}
