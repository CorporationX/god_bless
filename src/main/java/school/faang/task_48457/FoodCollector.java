package school.faang.task_48457;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class FoodCollector implements Runnable {
    private final House house;

    @Override
    public void run() {
        house.collectFood();
    }
}
