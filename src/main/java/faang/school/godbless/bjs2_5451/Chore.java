package faang.school.godbless.bjs2_5451;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Chore implements Runnable {

    private String taskName;

    @Override
    public void run() {
        System.out.println("Execute task: " + taskName + " in " + Thread.currentThread().getName());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
