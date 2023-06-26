package faang.school.godbless.sprint3.road;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
@AllArgsConstructor
public class City {
    private String name;
    private int location;
    private Map<String, Integer> distance = new HashMap<>();

    public Map<String, Integer> getDistances() {
        return distance;
    }
}
