package school.faang.bjs272991;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Chore implements Runnable {

    private final String chore;

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " takes chore " + chore);
        try {
            Thread.sleep(2000);
            System.out.println(chore + " is completed!");
        } catch (InterruptedException e) {
            System.out.println(chore + " was interrupted");
            Thread.currentThread().interrupt();
            throw new  IllegalStateException(e);
        }
    }
}
