package school.faang.MageTournament;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {
    private String name;
    private int year;
    private int points;

    public void addPoints(int points) {
        this.points += points;
    }
}
