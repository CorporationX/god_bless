package school.faang.weasleyfamily;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Random;

@Getter
@Setter
@AllArgsConstructor
public class Chore implements Runnable {

    private static final Random RANDOM = new Random();

    private String chore;

    @Override
    public void run() {
        System.out.println("Do chore: " + chore + " in thread: " + Thread.currentThread().getName());
        try {
            Thread.sleep(RANDOM.nextInt(2000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Completed chore: " + chore + " in thread: " + Thread.currentThread().getName());
    }
}
