package faang.school.godbless.big_bang_theory;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Task implements Runnable {

    private String name;
    private String task;

    @Override
    public void run() {
        System.out.println(name + " has started " + task);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println(name + " has been interrupted while performing " + task);
            return;
        }

        System.out.println(name + " has completed " + task);
    }
}
