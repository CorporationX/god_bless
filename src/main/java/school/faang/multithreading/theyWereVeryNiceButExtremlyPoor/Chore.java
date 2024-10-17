package school.faang.multithreading.theyWereVeryNiceButExtremlyPoor;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@AllArgsConstructor
public class Chore implements Runnable {
    private static final Logger log = LoggerFactory.getLogger(Chore.class);
    private String chore;

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " выполняет задачу: " + chore);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Произошло исключение " + e.getMessage());
            e.printStackTrace();
        }
    }
}
