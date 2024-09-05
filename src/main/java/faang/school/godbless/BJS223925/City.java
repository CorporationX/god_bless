package faang.school.godbless.BJS223925;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class City {
    private String name;
    private List<Location> distances;

    public City(String name, Location... distances) {
        this.name = name;
        this.distances = List.of(distances);
    }
}
