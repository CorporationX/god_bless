package school.faang.stream4.triwizardtournament;

import lombok.Data;

import java.util.List;

@Data
public class School {
    private final String name;
    private final List<Student> team;

    public int getTotalPoints() {
        return team.stream()
                .mapToInt(Student::getPoints)
                .sum();
    }

    public synchronized void updateScore(int reward) {
        SchoolUtil.distributePoints(team, reward);
    }

}
