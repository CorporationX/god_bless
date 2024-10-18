package school.faang.paveTheWay;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Location {
    private int x;
    private int y;

    public <T extends Locatable> double distanceTo(T obj) {
        Location objectLocation = obj.getLocation();
        int deltaX = this.getX() - objectLocation.getX();
        int deltaY = this.getY() - objectLocation.getY();
        return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
    }
}
