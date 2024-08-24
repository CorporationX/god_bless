package faang.school.godbless.Finger_Road;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Location {
    private String name;
    private double x;
    private double y;

    public Location(String name) {
        this.name = name;
    }

    public Location(double x, double y) {
        this.x = x;
        this.y = y;
    }
}
