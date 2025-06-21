package school.faang.sprint3.bjs2_81587;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Location {
    private int axisX;
    private int axisY;

    public double calculateDistance(Location target) {
        return Math.sqrt(
                Math.pow(axisX - target.getAxisX(), 2) + Math.pow(axisY - target.getAxisY(), 2)
        );
    }

    public static double calculateDistance(Location loc1, Location loc2) {
        return Math.sqrt(
                Math.pow(loc1.getAxisX() - loc2.getAxisX(), 2) + Math.pow(loc1.getAxisY() - loc2.getAxisY(), 2)
        );
    }
}
