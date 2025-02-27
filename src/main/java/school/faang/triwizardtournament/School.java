package school.faang.triwizardtournament;

import java.util.List;

public record School(String name, List<Student> team) {
    public double getTotalPoints() {
        return team.stream()
                .mapToDouble(Student::getPoints).sum();
    }
}
