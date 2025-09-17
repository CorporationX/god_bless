package school.faang.multithreading_parallelism_thread.bjs2_89646;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WeasleyFamily {
    public static void main(String[] args) {
        String[] chores = {
                "помыть посуду", "подмести пол", "приготовить ужин", "постирать белье",
                "сходить в магазин", "выхлопать половики", "покормить питомцев"
        };

        ExecutorService service = Executors.newCachedThreadPool();

        for (String chore : chores) {
            service.submit(new Chore(chore));
        }

        try {
            if (!service.awaitTermination(1, TimeUnit.MINUTES)) {
                service.shutdownNow();
            }
        } catch (InterruptedException e) {
            service.shutdownNow();
        }

    }
}
