package faang.school.godbless.Sprint4Future.Base;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class App {
    public static void main(String[] args) {
        MilitaryBase base1 = new MilitaryBase();
        MilitaryBase base2 = new MilitaryBase();

        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(base1);
        executorService.execute(base2);
        for (int i = 0; i < 100; i++) {
            executorService.execute(()-> base1.sendMessage(base2, "Encrypted message from base 1"));
            executorService.execute(()-> base2.sendMessage(base1, "Encrypted message from base 2"));
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        base1.stop();
        base2.stop();
        executorService.shutdown();
        try {
            executorService.awaitTermination(10, TimeUnit.HOURS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
