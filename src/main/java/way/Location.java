package way;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Location {
    private int x;
    private int y;

    public double getDistance(Location location) {
        return Math.sqrt(Math.pow(this.x - location.x, 2) + Math.pow(this.y - location.y, 2));
    }
}
