package school.faang.three_warlock_tournament;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Student {
    private String name;
    private int year;
    private int points;

    public void addPoints(int p) {
        this.points += p;
    }
}
