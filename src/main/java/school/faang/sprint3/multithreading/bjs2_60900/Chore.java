package school.faang.sprint3.multithreading.bjs2_60900;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

@AllArgsConstructor
public class Chore implements Runnable {
    private String title;

    @SneakyThrows
    @Override
    public void run() {
        Thread.sleep(250);
        System.out.printf("\nThread '%s' is performing the task '%s'", Thread.currentThread().getName(), title);
        Thread.sleep(500);
        System.out.printf("\nTask '%s' has been completed", title);
    }
}
