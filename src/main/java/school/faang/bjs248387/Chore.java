package school.faang.bjs248387;

import lombok.Data;

@Data
public class Chore implements Runnable {

    private static final long SLEEP_MILLISECOND = 2000;
    private final String chore;

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " : " + chore);
            Thread.sleep(SLEEP_MILLISECOND);
            System.out.println(chore + " task end");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
