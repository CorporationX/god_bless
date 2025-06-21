package school.faang.extremely_poor;

import lombok.Data;
import lombok.SneakyThrows;

@Data
public class Chore implements Runnable {
    private final String chore;

    @SneakyThrows
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " выполняет задачу: " + chore);
        Thread.sleep(20000);
        System.out.println(chore + " выполнена!");
    }
}
