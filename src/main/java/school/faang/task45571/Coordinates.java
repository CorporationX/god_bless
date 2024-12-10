package school.faang.task45571;

import lombok.Getter;

@Getter
public class Coordinates {
    public int firstCoordinate;
    public int secondCoordinate;

    public Coordinates(int firstCoordinate, int secondCoordinate) {
        validate(firstCoordinate, secondCoordinate);

        this.firstCoordinate = firstCoordinate;
        this.secondCoordinate = secondCoordinate;
    }

    private void validate(int firstCoordinate, int secondCoordinate) {
        if (firstCoordinate < 0 || secondCoordinate < 0) {
            throw new IllegalArgumentException("Coordinates can`t be less than 0");
        }
    }
}
