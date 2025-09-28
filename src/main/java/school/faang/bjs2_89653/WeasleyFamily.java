package school.faang.bjs2_89653;

import lombok.extern.slf4j.Slf4j;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class WeasleyFamily {
    public static void main(String[] args) {
        List<Chore> chores = new ArrayList<>();
        Chore washTheDishes = new Chore("Помыть посуду");
        Chore washTheFloors = new Chore("Вымыть полы");
        Chore cookTheFood = new Chore("Приготовить еду");
        chores.add(washTheDishes);
        chores.add(washTheFloors);
        chores.add(cookTheFood);
        ExecutorService executor = Executors.newCachedThreadPool();
        for (Chore task : chores) {
            executor.execute(task);
        }
        executor.shutdown();

        try {
            if (!executor.awaitTermination(30, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.info("{} был прерван", Thread.currentThread().getName());
            executor.shutdownNow();
        }
    }
}
