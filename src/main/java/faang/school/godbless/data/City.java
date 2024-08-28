package faang.school.godbless.data;

import lombok.Getter;

@Getter
public class City {
    private String name;
    private int[] distance;

    public City(String name, int... distance) {
        this.name = name;
        this.distance = distance;
    }

    public int getDistanceToCity(int cityIndex) {
        return distance[cityIndex];
    }
}
