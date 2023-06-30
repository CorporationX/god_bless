package faang.school.godbless.finally_normal_game;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class PigThread extends Thread {
    private String pigName;
    private String material;

    @Override
    public void run() {
        buildHouse();
    }

    private void buildHouse() {
        System.out.printf("%s started building a house out of %s (%s)\n",
                pigName, material, Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.printf("%s finished (%s)\n", pigName, Thread.currentThread().getName());
    }
}
