package faang.school.godbless.TheyWereVeryNiceButExtremelyPoor;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Chore implements Runnable{
    private String chore;
    @Override
    public void run() {
        try {
            doChore();
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void doChore(){
        System.out.println("Thread " + Thread.currentThread().getName() + " is doing chore: " + chore);
    }
}
