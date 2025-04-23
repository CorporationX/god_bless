import lombok.Getter;
import lombok.SneakyThrows;

import java.util.concurrent.TimeUnit;

public class Chore implements Runnable {
    private static final int WAITING_TIME_SECONDS = 3;

    @Getter
    private final String chore;

    public Chore(String chore) {
        this.chore = chore;
    }

    @SneakyThrows
    @Override
    public void run() {
        TimeUnit.SECONDS.sleep(WAITING_TIME_SECONDS);
        System.out.println("Thread's name: " + Thread.currentThread().getName() + " Task: " + chore);
    }
}

