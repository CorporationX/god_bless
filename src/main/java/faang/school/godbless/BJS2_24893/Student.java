package faang.school.godbless.BJS2_24893;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor

public class Student {
    private String name;
    private int year;
    private int points;

    public void setPoints(int points) {
        this.points = points;
    }
}
