package school.faang.bjs2_93152;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Student {
    private String name;
    private int year;
    private int points;

    public void addPoints(int points) {
        this.points += points;
    }

    @Override
    public String toString() {
        return name + " (Year " + year + ", Points: " + points + ")";
    }
}
