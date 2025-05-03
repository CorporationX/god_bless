package school.faang.but_extremly;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Chore implements Runnable {
    private String chore;

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " Make chore " + chore);
            Thread.sleep(1000);
            System.out.println(chore + " Done!");
        } catch (InterruptedException e) {
            System.out.println("Chore " + chore + "abort");
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);


        }
    }
}
