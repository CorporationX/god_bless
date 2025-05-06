package school.faang.bjs251129;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public class Task {

    private final String taskName;
    private final int taskDificulty;
    private final int taskReward;

    public Task(String name, int taskDificulty) {
        if (name == null || name.trim().isEmpty() || taskDificulty < 0) {
            log.error("Task name cannot be empty and difficulty cannot be negative: {}", taskDificulty);
            throw new IllegalArgumentException("Task name cannot be empty and difficulty cannot be negative: {}");
        }
        this.taskName = name;
        this.taskDificulty = taskDificulty;
        this.taskReward = taskDificulty * 10;
        log.info("Task created: name={}, difficulty={}, reward={}", taskName, taskDificulty, taskReward);

    }

}
