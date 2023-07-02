package faang.school.godbless.very_nice;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Chore implements Runnable {
    private String name;

    @Override
    public void run() {
        System.out.println("Поток " + Thread.currentThread().getName() + " выполняет следующую задачу: " + name);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException("Ошибка прерывания потока!");
        }
        System.out.println("Задача " + name + " выполнена потоком " + Thread.currentThread().getName());
    }
}
