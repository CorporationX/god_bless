package bjs2_35738;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@AllArgsConstructor
public class WeasleyFamily {
    List<Chore> chores;

    public void doChores() {
        ExecutorService executorService = Executors.newCachedThreadPool();

        for (Chore chore : chores) {
            executorService.submit(chore);
        }
        executorService.shutdown();
    }
}
