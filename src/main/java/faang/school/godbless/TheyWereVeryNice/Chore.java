package faang.school.godbless.TheyWereVeryNice;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Chore implements Runnable{
    private String task;
    @Override
    public void run() {
        System.out.println("Задача: " + task + " выполняется потоком " + Thread.currentThread().getName());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Задача: " + task + " выполнена");
    }
}
