package school.faang.naughtwoBJS261331;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class BigBangTheory {
    public static void main(String[] args) {
        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task("Sheldon", "theory preparation"));
        tasks.add(new Task("Leonard", "experimental design"));
        tasks.add(new Task("Howard", "instrument development"));
        tasks.add(new Task("Rajesh", "data analysis"));

        ExecutorService executor = Executors.newFixedThreadPool(4);

        for (Task task : tasks) {
            executor.submit(task);
        }

        log.debug("Tasks completed");
        executor.shutdown();
    }
}
