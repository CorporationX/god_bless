package school.faang.moduleone.sprintthree.task_43556;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class FoodCollector implements Runnable {
    private final House house;

    public void run() {
        house.collectFood();
    }
}
