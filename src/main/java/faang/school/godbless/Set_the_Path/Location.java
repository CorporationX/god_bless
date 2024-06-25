package faang.school.godbless.Set_the_Path;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.lang.Math;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Location {

    private double x;
    private double y;

    public static double getDistance(Location a, Location b) {
        return Math.sqrt((a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y));
    }
}
