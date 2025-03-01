package bjs262388;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Student {
    private String name;
    private int year;
    private int points;

    public void addPoints(int points) {
        this.setPoints(this.getPoints() + points);
    }
}
