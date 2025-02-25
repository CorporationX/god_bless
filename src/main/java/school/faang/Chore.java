package school.faang;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Chore implements Runnable {
    private final String title;

    @Override
    public void run() {
        System.out.printf("Началось выполнение задачи: %s\nПотоком: %s\n",
                title, Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.printf("Задача: %s была прервана\n", title);
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
        System.out.printf("Выполнение задачи: %s успешно завершилось!\n", title);
    }
}
