package finally_a_normal_game;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Random;

@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class PigThread extends Thread {
    private String pigName;
    private String material;

    private static final Random random = new Random();
    private static final int TIME_IN_DEVELOPMENT = random.nextInt(10 - 5) + 5;

    /**
     * When an object representing this thread is created, its start()
     * method is called; which executes a call to this thread's
     * run method. Starts the construction of the house from the {@code material}.
     * The construction takes {@value #TIME_IN_DEVELOPMENT} seconds.
     */
    public void run() {
        System.out.printf("%s начал строить дом из %s\n", getPigName(), getMaterial());
        try {
            Thread.sleep(TIME_IN_DEVELOPMENT * 1000L);
        } catch (InterruptedException e) {
            throw new IllegalArgumentException(e);
        }
        System.out.printf("%s закончил строить дом из %s\n", getPigName(), getMaterial());
    }
}
