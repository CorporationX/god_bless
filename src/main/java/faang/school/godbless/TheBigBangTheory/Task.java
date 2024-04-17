package faang.school.godbless.TheBigBangTheory;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Task implements Runnable {

    private String name;
    private String task;

    @Override
    public void run() {
        try {
            exercise();
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    private void exercise() {
        System.out.println(name + " doing exercise: \"" + task + "\"");
    }
}
