package school.faang.BJS2_36827;

import lombok.AllArgsConstructor;

import java.util.Random;

@AllArgsConstructor
public class Chore implements Runnable {
    private String choreName;
    private static final Random random = new Random();
    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName() + "   " + choreName +  " - работа начата");
        try {
            Thread.sleep(random.nextInt(5000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName() + "   " + choreName +  " - выполнено");
    }
}
