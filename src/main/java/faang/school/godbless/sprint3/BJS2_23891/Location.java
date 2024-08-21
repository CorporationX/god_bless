package faang.school.godbless.sprint3.BJS2_23891;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@AllArgsConstructor
@ToString
@Getter
@Setter
public class Location {
    private double x;
    private double y;

    public Location(Location location) {
        x = location.getX();
        y = location.getY();
    }

    public double getDistanceBetweenLocations(Location location) {
        double dx = this.x - location.getX();
        double dy = this.y - location.getY();
        return Math.sqrt(dx * dx + dy * dy);
    }
}
