package faang.school.godbless.BJS223925;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class City {
    private String name;
    private int[] distances;

    public City(String name, int... distances) {
        this.name = name;
        this.distances = distances;
    }
}
