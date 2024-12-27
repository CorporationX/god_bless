package school.faang.task_48743;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

@AllArgsConstructor
public class Chore implements Runnable {
    private String chore;

    @SneakyThrows
    @Override
    public void run() {
        System.out.println("Задача начала выполнятся: " + Thread.currentThread().getName());
        Thread.sleep(100);
        System.out.println("Задача выполена: " + Thread.currentThread().getName());
    }
}
