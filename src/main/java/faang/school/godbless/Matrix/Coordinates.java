package faang.school.godbless.Matrix;
import lombok.Data;

@Data
public class Coordinates {
    private int row;
    private int column;

    public Coordinates(int row, int column) {
        this.row = row;
        this.column = column;
    }
}
