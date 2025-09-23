package school.faang.module3.weasley;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Chore implements Runnable {

    private final String chore;

    @Override
    public void run() {
        System.out.printf("Поток %s начал выполнять задачу %s%n", Thread.currentThread().getName(), chore);
        try {
            System.out.printf("Выполнение обязанности %s началось%n", chore);
            Thread.sleep(5000);
            System.out.printf("Выполнение обязанности %s закончено%n", chore);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.printf("Выполнение обязанности %s прервано%n", chore);
        }
    }
}
