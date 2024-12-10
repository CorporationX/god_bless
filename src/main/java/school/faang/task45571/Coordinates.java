package school.faang.task45571;

import lombok.Getter;

@Getter
public class Coordinates {
    public int x;
    public int y;

    public Coordinates(int x, int y) {
        validate(x, y);

        this.x = x;
        this.y = y;
    }

    private void validate(int x, int y) {
        if (x < 0 || y < 0) {
            throw new IllegalArgumentException("Coordinates can`t be less than 0");
        }
    }
}
