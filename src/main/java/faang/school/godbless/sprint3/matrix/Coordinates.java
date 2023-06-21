package faang.school.godbless.sprint3.matrix;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Coordinates {
    private int x;
    private int y;

    private Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static Coordinates of(int x, int y) {
        return new Coordinates(x, y);
    }
}
