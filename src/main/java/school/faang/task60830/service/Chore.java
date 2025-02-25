package school.faang.task60830.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.SneakyThrows;

@AllArgsConstructor
@Getter
public class Chore implements Runnable {
    private String title;

    @SneakyThrows
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " начинает задачу: " + title);
        System.out.println("Работа работается");
        Thread.sleep(10000);
        System.out.println("Задача " + title + " выполнена");
    }
}