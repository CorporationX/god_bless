package school.faang.bjs2_72219;

import lombok.experimental.UtilityClass;
import school.faang.bjs2_72219.model.Location;

@UtilityClass
public class LocationUtil {
    public final Location castleLocation = new Location(0, 0);

    public double getDistance(Location from, Location to) {
        int dx = from.x() - to.x();
        int dy = from.y() - to.y();
        return Math.sqrt(dx * dx + dy * dy);
    }
}