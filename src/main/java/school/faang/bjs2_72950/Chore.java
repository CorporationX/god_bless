package school.faang.bjs2_72950;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class Chore implements Runnable {
    private static final double MIN_SLEEP_VALUE = 3000;
    private static final double MAX_SLEEP_VALUE = 7000;

    private final String chore;

    @Override
    public void run() {
        long sleepAmount = getSleepTime();
        log.info("Start the task [{}]. Sleep {} sec.  Chore name is: {}",
            Thread.currentThread().getName(), sleepAmount, this.chore);
        try {
            Thread.sleep(sleepAmount);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        log.info("The task [{}] is finished. Chore name is: {}", Thread.currentThread().getName(), this.chore);
    }

    /**
     * @return возвращает случайное число в интервале MIN_SLEEP_VALUE и MAX_SLEEP_VALUE
     */
    private long getSleepTime() {
        double dbl = Math.random() / Math.nextDown(1.0);
        return Math.round(MIN_SLEEP_VALUE * (1.0 - dbl) + MAX_SLEEP_VALUE * dbl);
    }
}
