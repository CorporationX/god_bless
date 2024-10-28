package MultithreadingTournament;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Student {
    private String name;
    private int year;
    private int points;

    public void addReward(int point) {
        points += point;
    }
}
