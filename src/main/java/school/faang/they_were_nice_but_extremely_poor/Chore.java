package school.faang.they_were_nice_but_extremely_poor;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Chore implements Runnable {
    private final String chore;

    @Override
    public void run() {
        try {
            System.out.println("Новая задача " + this.chore);
            Thread.sleep(100);
            System.out.println("Задача " + this.chore + " выполнил " + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
