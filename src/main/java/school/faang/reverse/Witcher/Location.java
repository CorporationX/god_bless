package school.faang.reverse.Witcher;

import lombok.Getter;

@Getter
class Location {
    private final double X;
    private final double Y;

    public Location(double X, double Y) {
        this.X = X;
        this.Y = Y;
    }
}