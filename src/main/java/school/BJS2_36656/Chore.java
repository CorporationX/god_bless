package school.BJS2_36656;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Chore implements Runnable {

    private String chore;

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " выполняет: " + chore);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
