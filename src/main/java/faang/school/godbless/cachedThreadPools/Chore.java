package faang.school.godbless.cachedThreadPools;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Chore implements Runnable {
    private String chore;

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " has started " + chore);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName() + " has ended " + chore);
    }
}
