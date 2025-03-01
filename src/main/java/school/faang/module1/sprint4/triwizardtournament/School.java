package school.faang.module1.sprint4.triwizardtournament;

import java.util.List;

public record School(String name, List<Student> team) {
    public int getTotalPoints() {
        return team.stream()
                .mapToInt(Student::getPoints).sum();
    }
}