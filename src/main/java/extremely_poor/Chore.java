package extremely_poor;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

@RequiredArgsConstructor
public class Chore implements Runnable {
    private final String taskName;

    @SneakyThrows
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " does task: " + taskName);
        Thread.sleep(3000);
        System.out.println(Thread.currentThread().getName() + " finished implementing task: " + taskName);
    }
}
