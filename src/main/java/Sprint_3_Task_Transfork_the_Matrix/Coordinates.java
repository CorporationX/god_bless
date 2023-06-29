package Sprint_3_Task_Transfork_the_Matrix;

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
