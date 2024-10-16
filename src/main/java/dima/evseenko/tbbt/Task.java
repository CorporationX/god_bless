package dima.evseenko.tbbt;

import lombok.RequiredArgsConstructor;

import java.util.Random;

@RequiredArgsConstructor
public class Task implements Runnable {
    private final String name;
    private final String task;

    @Override
    public void run() {
        System.out.printf("%s начал выполнение - %s%n", name, task);
        try {
            Thread.sleep(new Random().nextInt(3000 - 1000) + 1000);

            if (new Random().nextInt(3) == 1) {
                throw new Exception("Ошибка выполнения %s задачи - %s".formatted(name, task));
            } else {
                System.out.printf("%s выполнил - %s%n", name, task);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
