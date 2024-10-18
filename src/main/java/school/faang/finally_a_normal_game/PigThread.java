package school.faang.finally_a_normal_game;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Getter
@Slf4j
public class PigThread extends Thread {
    private String pigName;
    private String material;

    public void buildHouse(int delay) {
        System.out.println(getPigName() + " has started building a house with " + getMaterial());
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            log.error("The exception in threads has occurred connected to sleep() method", e);
            e.printStackTrace();
        }
        System.out.println(getPigName() + " finished building a house with " + getMaterial());
    }
}
