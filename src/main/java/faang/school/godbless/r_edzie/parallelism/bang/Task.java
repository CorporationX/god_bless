package faang.school.godbless.r_edzie.parallelism.bang;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Task implements Runnable {
    private String name;
    private String task;


    @Override
    public void run() {
        System.out.println("START");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
