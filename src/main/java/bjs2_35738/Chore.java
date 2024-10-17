package bjs2_35738;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Chore implements Runnable {
    private String chore;

    @Override
    public void run() {
        System.out.println("Thread: " +Thread.currentThread().getName() + ". Doing: " + chore);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
