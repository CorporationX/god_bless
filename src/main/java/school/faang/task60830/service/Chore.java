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
        System.out.println(Thread.currentThread().getName());
        System.out.println("Что-то происходит");
        Thread.sleep(1000);
    }
}