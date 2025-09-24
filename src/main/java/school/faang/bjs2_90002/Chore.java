package school.faang.bjs2_90002;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Chore implements Runnable {
    private static final int SLEEPING_TIME = 5000;
    private String chore;

    @Override
    public void run() {
        System.out.printf("Поток %s начал выполнять задачу: %s%n", Thread.currentThread().getName(), chore);
        try {
            Thread.sleep(SLEEPING_TIME);
        } catch (InterruptedException e) {
            throw new RuntimeException("Поток не смог уснуть )");
        }
        System.out.printf("Поток %s закончил выполнять задачу: %s%n", Thread.currentThread().getName(), chore);
    }
}
