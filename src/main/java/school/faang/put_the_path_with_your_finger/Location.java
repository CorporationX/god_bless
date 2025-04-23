package school.faang.put_the_path_with_your_finger;

import lombok.Getter;

@Getter
public class Location {
    private final double coordX;
    private final double coordY;

    public Location(double coordX, double coordY) {
        this.coordX = coordX;
        this.coordY = coordY;
    }

    @Override
    public String toString() {
        return String.format("(%.2f, %.2f)", coordX, coordY);
    }
}
