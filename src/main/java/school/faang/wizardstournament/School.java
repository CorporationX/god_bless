package school.faang.wizardstournament;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.Random;

@AllArgsConstructor
public class School {
    @Getter
    private String name;
    private List<Student> team;

    public Integer getTotalPoints() {
        return team.stream()
                .mapToInt(Student::getPoints)
                .sum();
    }

    public void addReword(int reward) {
        Student winner = team.get(new Random().nextInt(team.size()));
        winner.addPoints(reward);
    }
}
