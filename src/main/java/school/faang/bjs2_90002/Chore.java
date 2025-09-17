package school.faang.bjs2_90002;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Chore implements Runnable {
    String chore;

    @Override
    public void run() {
        System.out.printf("Поток %s начал выполнять задачу: %s%n", Thread.currentThread().getName(), chore);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException("Поток не смог уснуть )");
        }
        System.out.printf("Поток %s закончил выполнять задачу: %s%n", Thread.currentThread().getName(), chore);
    }
}
