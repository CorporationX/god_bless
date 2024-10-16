package bjs2_35738;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@AllArgsConstructor
public class WeasleyFamily {
    private List<Chore> chores;

    public void doChores() {
        ExecutorService executorService = Executors.newCachedThreadPool();

        for (Chore chore : chores) {
            executorService.submit(chore);
        }

        executorService.shutdown();

        while (!executorService.isTerminated()) {
            System.out.println("работаем");
        }
    }
}
