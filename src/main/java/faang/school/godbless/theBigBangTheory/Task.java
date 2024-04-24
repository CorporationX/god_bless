package faang.school.godbless.theBigBangTheory;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Task implements Runnable{
    private String name;
    private String task;

    @Override
    public void run() {
        System.out.println(name+" has started to work on "+task);

        try {
            Thread.sleep(5000);
            System.out.println(name+" has done the work on "+task);
        } catch (InterruptedException e) {
            throw new RuntimeException(name+ " has been interrupted and stopped to work on "+task);
        }

    }
}
