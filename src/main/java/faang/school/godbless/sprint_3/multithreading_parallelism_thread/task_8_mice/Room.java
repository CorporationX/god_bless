package faang.school.godbless.sprint_3.multithreading_parallelism_thread.task_8_mice;

import java.util.ArrayList;
import java.util.List;

public record Room(String name, List<Food> foodList) {
    public Room(String name) {
        this(name, new ArrayList<>());
    }
}
