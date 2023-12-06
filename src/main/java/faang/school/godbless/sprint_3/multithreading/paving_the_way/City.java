package faang.school.godbless.sprint_3.multithreading.paving_the_way;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Map;

@AllArgsConstructor
@Getter
public class City {
    private String name;
    private int location;
    private Map<String, Integer> nearestCities;
}
