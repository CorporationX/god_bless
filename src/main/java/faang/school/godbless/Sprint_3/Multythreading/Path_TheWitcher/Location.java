package faang.school.godbless.Sprint_3.Multythreading.Path_TheWitcher;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Location {
    private int x;
    private int y;

    public static int getDistance(Location firstLocation, Location secondLocation) {
        return (int) Math.sqrt(Math.pow(firstLocation.x - secondLocation.x, 2) + Math.pow(firstLocation.y - secondLocation.y, 2));
    }
}