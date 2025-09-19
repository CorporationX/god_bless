package school.faang.bjs2_89890;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Chore implements Runnable {
    private String chore;

    @Override
    public void run() {
        System.out.printf("Поток %s начал выполнение задачи \"%s\"%n", Thread.currentThread().getName(), chore);
        try {
            Thread.sleep((int) (Math.random() * 7000));
        } catch (InterruptedException e) {
            System.out.println("Поток прерван!");
        }
        System.out.printf("Поток %s закончил выполнение задачи \"%s\"%n", Thread.currentThread().getName(), chore);
    }
}
