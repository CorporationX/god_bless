package Sprint_3_Task14;

import lombok.Data;

@Data
public class Coordinates {
    private int X;
    private int Y;

    public Coordinates(int x, int y) {
        X = x;
        Y = y;
    }
}
