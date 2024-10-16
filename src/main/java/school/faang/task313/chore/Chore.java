package school.faang.task313.chore;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Chore implements Runnable {
    private String chore;

    @Override
    public void run() {
        try {
            Thread.sleep(3000);
            System.out.println(Thread.currentThread().getName() + " " + chore);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e.getMessage());
        }
    }
}
