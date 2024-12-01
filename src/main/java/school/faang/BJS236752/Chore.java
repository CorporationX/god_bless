package school.faang.BJS236752;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Chore implements Runnable {
    private String chore;

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + " сделал действие: " + chore);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
