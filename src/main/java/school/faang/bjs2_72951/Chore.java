package school.faang.bjs2_72951;

import lombok.Data;

@Data
public class Chore implements Runnable {

    private final String chore;

    @Override
    public void run() {
        try {
            System.out.printf("Chore -> %s, has started\n", Thread.currentThread().getName());
            Thread.sleep(1000);
            System.out.printf("Has finished -> %s\n", Thread.currentThread().getName());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
