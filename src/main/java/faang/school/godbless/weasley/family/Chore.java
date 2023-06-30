package faang.school.godbless.weasley.family;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Chore implements Runnable {
    private String taskName;

    @Override
    public void run() {
        System.out.println(taskName + " in progress " + Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(taskName + " done " + Thread.currentThread().getName());
    }
}
