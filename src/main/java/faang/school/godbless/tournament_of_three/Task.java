package faang.school.godbless.tournament_of_three;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Task {
    private String name;
    private int difficulty;
    private int reward;

    public int getTotalReward() {
        return difficulty * reward;
    }
}
