package faang.school.godbless.BJS224164;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Task implements Runnable {
    private String name;
    private String task;

    @Override
    public void run() {
        try {
            System.out.println(name + " started " + task);
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            System.out.println("ERROR");
        }
    }
}
