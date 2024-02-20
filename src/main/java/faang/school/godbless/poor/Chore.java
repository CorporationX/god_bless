package faang.school.godbless.poor;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Chore implements Runnable {

    private String chore;

    @Override
    public void run() {
        System.out.println( Thread.currentThread().getName() + " is performing chore: " + chore );
        try {
            Thread.sleep( 2000 );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println( Thread.currentThread().getName() + " has finished chore: " + chore );
    }
}
