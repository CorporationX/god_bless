package school.faang.bjs2_93141;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Student {
    private String name;
    private int year;
    private int points;

    public void addPoint(int point) {
        this.points += point;
    }
}
