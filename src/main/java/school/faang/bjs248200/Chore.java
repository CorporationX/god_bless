package school.faang.bjs248200;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Chore implements Runnable {
    private final String chore;

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " - begins work");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName() + " - ends work");
    }
}