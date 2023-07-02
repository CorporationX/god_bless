package faang.school.godbless.flip_a_matrix;

import lombok.Data;

@Data
public class Coordinates {

    private int x;
    private int y;

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
