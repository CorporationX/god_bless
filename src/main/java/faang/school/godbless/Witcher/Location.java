package faang.school.godbless.Witcher;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Location {
    private int x;
    private int y;

    public double calculateDistance(Location location) {
        return Math.sqrt(Math.pow(location.x - x, 2) + Math.pow(location.y - y, 2));
    }
}
