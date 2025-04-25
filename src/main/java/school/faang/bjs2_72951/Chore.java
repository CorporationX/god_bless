package school.faang.bjs2_72951;

import lombok.Data;

@Data
public class Chore implements Runnable {

    private final String chore;

    @Override
    public void run() {
        try {
            System.out.printf("Chore -> %s (%s), has started\n", chore, Thread.currentThread().getName());
            Thread.sleep(1000);
            System.out.printf("Has finished -> %s (%s)\n", chore, Thread.currentThread().getName());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.printf("Поток (%s) был прерван, завершаем работу", Thread.currentThread());
        }
    }
}
