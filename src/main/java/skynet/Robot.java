package skynet;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

@AllArgsConstructor
public class Robot {
    private String target;

    @SneakyThrows
    public synchronized void attack() {
        System.out.println(Thread.currentThread().getName() + " start attack " + target);
        Thread.sleep(3000);
        System.out.println(Thread.currentThread().getName() + " finished attack " + target);
    }
}
