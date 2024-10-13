package school.faang.weasley;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Chore implements Runnable {
    private String chore;

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " выполняет задачу: " + chore);
            Thread.sleep(1000);
            System.out.println("Задача " + chore + " выполнена!");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
