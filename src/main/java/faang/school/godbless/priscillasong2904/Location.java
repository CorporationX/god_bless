package faang.school.godbless.priscillasong2904;

import lombok.Getter;

@Getter
public class Location {
    private int coordinateX;
    private int coordinateY;

    public Location(int coordinateX, int coordinateY) {
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
    }
}
