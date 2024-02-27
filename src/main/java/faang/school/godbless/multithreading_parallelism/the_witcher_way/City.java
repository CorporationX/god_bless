package faang.school.godbless.multithreading_parallelism.the_witcher_way;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class City {
    private String name;
    private Location location;
    private int distance;

}
