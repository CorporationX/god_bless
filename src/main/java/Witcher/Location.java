package Witcher;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Location {
    private int x;
    private int y;

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
