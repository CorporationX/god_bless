package school.faang.task_48810;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class WeasleyFamily {

    public static void main(String[] args) {
        try {
            List<String> tasks = new ArrayList<>();
            tasks.add("помыть посуду");
            tasks.add("подмести пол");
            tasks.add("приготовить ужин");
    
            ExecutorService executorService = Executors.newCachedThreadPool();
            tasks.forEach(task -> executorService.execute(new Chore(task)));
            executorService.shutdown();
            executorService.awaitTermination(5, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        }
    }
}
