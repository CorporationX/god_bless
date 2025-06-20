package school.faang.weasleyFamily81240;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Chore implements Runnable {
    private String chore;

    @Override
    public void run() {
        System.out.printf("выполненно действие: %s потоком: %s %n", this.chore, Thread.currentThread().getName());
    }
}
