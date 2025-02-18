package school.faang;

import lombok.Getter;

@Getter
public class Location {
    private final int posX;
    private final int posY;

    public Location(int posY, int posX) {
        this.posY = posY;
        this.posX = posX;
    }
}
