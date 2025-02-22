package school.faang.bjs2_60855;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Chore implements Runnable {

    private String title;

    @Override
    public void run() {
        System.out.printf("Задача: \"%s\" выполняется в потоке %s%n", title, Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
            System.out.printf("Задача: \"%s\" - выполнена!%n", title);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
