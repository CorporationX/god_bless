package faang.school.godbless.threads.vedmak;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Location {
    private int x;
    private int y;

    public static Location getCoordinates(String location) {
        switch (location) {
            case "Velen" -> {
                return new Location(15, 21);
            }
            case "Toussaint" -> {
                return new Location(35, 10);
            }
            case "White Orchard" -> {
                return new Location(80, 60);
            }
            case "Skellige" -> {
                return new Location(40, 55);
            }
            default -> {
                return new Location(0, 0);
            }
        }
    }

    public static double getDistance(Location location1, Location location2) {
        double firstOperand = Math.pow(location1.getX() - location2.getX(), 2);
        double secondOperand = Math.pow(location1.getY() - location2.getY(), 2);
        return Math.sqrt(firstOperand + secondOperand);
    }
}
