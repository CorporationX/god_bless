package school.faang.fourthStream.BJS2_39021;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Student {
    private final String name;
    private int year;
    private int points;

    public void addPoints(int reward) {
        this.points += reward;
    }
}
