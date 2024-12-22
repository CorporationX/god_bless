package school.faang.task_48394;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

@Getter
public class Room {
    private final List<Food> foodList = new ArrayList<>();
    private final AtomicBoolean isBeingVisited = new AtomicBoolean(false);
}
