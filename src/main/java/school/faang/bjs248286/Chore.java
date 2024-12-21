package school.faang.bjs248286;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

@AllArgsConstructor
public class Chore implements Runnable {
    private final String chore;

    @SneakyThrows
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " started");
        Thread.sleep(Constants.TIMEOUT);
        System.out.println(chore + " completed");
    }
}
