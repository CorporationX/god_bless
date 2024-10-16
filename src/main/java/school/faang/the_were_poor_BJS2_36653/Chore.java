package school.faang.the_were_poor_BJS2_36653;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Chore implements Runnable {
    private String chore;

    @Override
    public void run() {
        try {
            System.out.println("Chore: \"" + chore + "\" start execute with: " + Thread.currentThread().getName());
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("Chore: \"" + chore + "\" was interrupted");
        }
    }
}
