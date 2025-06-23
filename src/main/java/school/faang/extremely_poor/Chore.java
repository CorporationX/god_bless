package school.faang.extremely_poor;

import lombok.Data;
import lombok.SneakyThrows;

@Data
public class Chore implements Runnable {
    private static final int TIME_SLEEP = 20000;
    private final String chore;

    @SneakyThrows
    @Override
    public void run() {
        System.out.printf("%s выолняет задачу: %s\n", Thread.currentThread().getName(), chore);
        Thread.sleep(TIME_SLEEP);
        System.out.println(chore + " выполнена!");
    }
}