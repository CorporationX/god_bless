package school.faang.BJS2_60708;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

@AllArgsConstructor
public class Chore implements Runnable {
    private final String chore;

    @SneakyThrows
    @Override
    public void run() {
        System.out.printf("Имя потока: %s выполняет задачу: %s%n",
                Thread.currentThread().getName(), chore);
        Thread.sleep(100);
    }
}
