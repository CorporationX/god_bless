package faang.school.godbless.UseYourFingerToShowTheWay;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;

@Data
@AllArgsConstructor
public class City {
    private String name;
    private Map<String, Integer> distances;

    public int getDistanceTo(String city) {
        return distances.getOrDefault(city, Integer.MAX_VALUE);
    }
}
