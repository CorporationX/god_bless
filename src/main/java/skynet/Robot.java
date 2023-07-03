package skynet;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

@AllArgsConstructor
public class Robot {
    private final String target;

    @SneakyThrows
    public void attack() {
        synchronized (target) {
            System.out.println(Thread.currentThread().getName() + " start attack " + target);
            Thread.sleep(3000);
            System.out.println(Thread.currentThread().getName() + " finished attack " + target);
        }
    }
}
