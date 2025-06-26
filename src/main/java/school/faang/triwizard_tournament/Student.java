package school.faang.triwizard_tournament;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {
    private String name;
    private int year;
    private int points;

    public void addPoints(int point) {
        if (point > 0) {
            points += point;
        }
    }
}
