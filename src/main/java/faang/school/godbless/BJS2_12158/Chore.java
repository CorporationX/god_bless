package faang.school.godbless.BJS2_12158;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Chore implements Runnable {
    private String chore;



    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName() + ":\nChore: " + chore + " is started");
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName() + "\nChore: " + chore + " is done");
    }
}
