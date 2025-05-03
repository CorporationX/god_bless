package school.faang.reverse.Witcher;

import lombok.Getter;

@Getter
class Location {
    private final double x;
    private final double y;

    public Location(double x, double y) {
        this.x = x;
        this.y = y;
    }
}