package school.faang.bjs2_87247;

import lombok.Getter;

public class Coordinates {
    @Getter
    private final int coordinateX;
    @Getter
    private final int coordinateY;

    public Coordinates(int coordinateX, int coordinateY) {
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
    }
}
