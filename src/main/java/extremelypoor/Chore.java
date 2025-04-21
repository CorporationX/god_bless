package extremelypoor;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Chore implements Runnable {
    private String chore;

    @Override
    public void run() {
        try {
            System.out.printf("Chore is completing: %s in %s%n", chore, Thread.currentThread().getName());
            Thread.sleep(1000);
            System.out.printf("Chore is completed: %s in %s%n ", chore, Thread.currentThread().getName());
        } catch (InterruptedException e) {
            System.out.printf("Задача \"%s\" была прервана в потоке %s.%n", chore, Thread.currentThread().getName());
            Thread.currentThread().interrupt();
        }
    }
}
