package faang.school.godbless.Parallelism.Witcher;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class City {

    private String name;
    private Location location;
    private int distanceFromWitcher;

    public int calculateDistanceToCity(City otherCity) {
        int differenceByX = Math.abs(this.location.getX() - otherCity.getLocation().getX());
        int differenceByY = Math.abs(this.location.getY() - otherCity.getLocation().getY());
        return differenceByX + differenceByY;
    }
}

