package faang.school.godbless.fingerPath;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class City {
    private String name;
    private Location location;
    private List<Integer> distances;
}
