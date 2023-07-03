package faang.school.godbless.theyWere;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class Chore implements Runnable {

    private String chore;

    public Chore(String chore) {
        this.chore = chore;
    }

    @Override
    public void run() {
        System.out.println("Task in progress: " + chore + " in the stream" + Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Task--> " + chore + " completed");
    }
}
