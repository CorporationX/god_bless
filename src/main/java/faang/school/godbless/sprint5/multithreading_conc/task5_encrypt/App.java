package faang.school.godbless.sprint5.multithreading_conc.task5_encrypt;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class App {

    public static void main(String[] args) throws InterruptedException {
        MilitaryBase militaryBase1 = new MilitaryBase();
        MilitaryBase militaryBase2 = new MilitaryBase();

        ExecutorService executor = Executors.newCachedThreadPool();

        executor.execute(militaryBase1);
        executor.execute(militaryBase2);

        for (int i = 0; i < 10; i++) {
            int finalI = i;
            executor.execute(() -> {
                try {
                    militaryBase1.sendMessage("База 1. Прием! " + finalI, militaryBase2);
                    militaryBase2.sendMessage("База 1. Прием! " + finalI, militaryBase2);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }


        if (executor.awaitTermination(10, TimeUnit.SECONDS)) {

        }

        militaryBase2.stop();
        militaryBase1.stop();
        executor.shutdown();

    }
}
