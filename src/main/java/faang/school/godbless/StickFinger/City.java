package faang.school.godbless.StickFinger;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class City {
    private String name;
    private int location;
    private List<Integer> distanceToOtherCities = new ArrayList<>();

    public City(String name, int location, int ... otherCities) {
        this.name = name;
        this.location = location;
        for (int otherCity : otherCities) {
            distanceToOtherCities.add(otherCity);
        }
    }
}
