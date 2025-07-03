package school.faang.bjs282831;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class School {
    private final String name;
    private final List<Student> team;

    public int getTotalPoints() {
        return team.stream()
                .mapToInt(Student::getPoints)
                .sum();
    }

    public void distributeReward(int totalReward) {
        if (team.isEmpty()) return;

        int baseReward = totalReward / team.size();
        int remainder = totalReward % team.size();

        for (int i = 0; i < team.size(); i++) {
            Student student = team.get(i);
            int reward = baseReward + (i < remainder ? 1 : 0);
            student.addPoints(reward);
        }
    }
}
