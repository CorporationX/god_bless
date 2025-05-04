package school.faang.but_extremly;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Chore implements Runnable {
    private String chore;
    private final int TIMEOUT = 1000;

    @Override
    public void run() {
        try {
            System.out.printf("%s Make chore %s", Thread.currentThread().getName(), chore);
            Thread.sleep(TIMEOUT);
            System.out.println(chore + " Done!");
        } catch (InterruptedException e) {
            System.out.println("Chore " + chore + "abort");
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);


        }
    }
}
