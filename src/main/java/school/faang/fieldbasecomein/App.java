package school.faang.fieldbasecomein;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {
    public static void main(String[] args) {
        MilitaryBase base1 = new MilitaryBase();
        MilitaryBase base2 = new MilitaryBase();

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        executorService.execute(base1);
        executorService.execute(base2);

        base1.sendMessage(base2, "Alpha, move to sector 3.");
        base2.sendMessage(base1, "Roger that, moving.");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        base1.stop();
        base2.stop();

        executorService.shutdown();

        try {
            if (!executorService.awaitTermination(10, java.util.concurrent.TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }

        System.out.println("All bases stopped. Communication terminated.");
    }
}

