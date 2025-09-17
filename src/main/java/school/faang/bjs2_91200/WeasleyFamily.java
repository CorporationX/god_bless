package school.faang.bjs2_91200;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
@Getter
public class WeasleyFamily {
    private List<String> chores = new ArrayList<>();

    public void doTask() {
        ExecutorService executors = Executors.newCachedThreadPool();
        for (int i = 0; i < chores.size(); i++) {
            Chore task = new Chore(chores.get(i));
            executors.submit(task);
        }
        executors.shutdown();
    }

    public void addTask(String task) {
        if (task == null && task.isBlank()) {
            log.info("Task not be null or have only space");
            throw new IllegalArgumentException("Задача не может быть пустой!");
        }
        chores.add(task);
    }
}
