package school.faang.Mnogopotochka.ParallelismThread.BJS2_36706;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Chore implements Runnable {
    private static final Logger logger = LoggerFactory.getLogger(Chore.class);
    private String chore;

    public Chore(String chore) {
        this.chore = chore;
    }

    @Override
    public void run() {
        try {
            System.out.println("Выполняется задача: " + chore + " в потоке: " + Thread.currentThread().getName());

            Thread.sleep(2000);

            System.out.println("Задача: " + chore + " завершена в потоке: " + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Задача: " + chore + " была прервана.");
            logger.error("Задача была прервана", e);
        }
    }
}
