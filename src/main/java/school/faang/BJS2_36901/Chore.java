package school.faang.BJS2_36901;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Chore implements Runnable{
private String chore;

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " doing task ; " + chore);
        try {
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + "complete task ; "+ chore);
        } catch (InterruptedException e) {
            System.out.println("task been interapted ; " + chore);;
        }

    }
}
