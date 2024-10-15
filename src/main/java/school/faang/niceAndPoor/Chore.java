package school.faang.niceAndPoor;

import lombok.Data;
import lombok.SneakyThrows;

@Data
public class Chore implements Runnable{
    private final String chore;

    @SneakyThrows
    @Override
    public void run() {
        System.out.printf("Thread started working: %s\n", Thread.currentThread().getName());
        Thread.sleep(2000);
        System.out.printf("Thread stopped working: %s\n", Thread.currentThread().getName());
    }
}
