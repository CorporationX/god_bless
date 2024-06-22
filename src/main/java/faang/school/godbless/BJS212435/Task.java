package faang.school.godbless.BJS212435;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Task implements Runnable {
    private String name;
    private String task;

    @Override
    public void run() {
        System.out.println(name + " starting doing the " + task);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException("Something went wrong" + e);
        }
        System.out.println(name + " finish the " + task);
    }
}
