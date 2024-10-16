package school.faang.multithreading.parallelism.very.nice.but.extremely.poor;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

@AllArgsConstructor
public class Chore implements Runnable {
    private String chore;

    @SneakyThrows
    @Override
    public void run() {
        System.out.println("Поток: " + Thread.currentThread().getName() + " выполняет задачу: " + chore);
        Thread.sleep(500);
        System.out.println("Задача: " + chore + " выполнена");
    }
}
