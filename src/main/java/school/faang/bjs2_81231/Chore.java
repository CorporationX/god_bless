package school.faang.bjs2_81231;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

@AllArgsConstructor
public class Chore implements Runnable {
    private String chore;

    @SneakyThrows
    @Override
    public void run() {
        System.out.printf("Thread: %s, chore: %s%n", Thread.currentThread().getName(), chore);
        Thread.sleep(2000);
    }
}
