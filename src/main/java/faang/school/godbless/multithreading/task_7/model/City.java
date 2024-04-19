package faang.school.godbless.multithreading.task_7.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class City {
    private final String name;
    private final Location location;
    private final int distance;
}
