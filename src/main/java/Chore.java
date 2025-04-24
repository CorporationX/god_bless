import lombok.Data;
import lombok.SneakyThrows;

import java.util.concurrent.TimeUnit;

@Data
public class Chore implements Runnable {
    private static final int WAITING_TIME_SECONDS = 3;

    private final String chore;

    @SneakyThrows
    @Override
    public void run() {
        TimeUnit.SECONDS.sleep(WAITING_TIME_SECONDS);
        System.out.println("Thread's name: " + Thread.currentThread().getName() + " Task: " + chore);
    }
}

