package extremelypoor;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Chore implements Runnable {
    private String chore;

    @Override
    public void run() {
        try {
            System.out.println("Chore is completing: " + chore + " in " + Thread.currentThread().getName());
            Thread.sleep(1000);
            System.out.println("Chore is completed: " + chore + " in " + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
