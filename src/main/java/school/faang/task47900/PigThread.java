package school.faang.task47900;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Getter
@AllArgsConstructor
public class PigThread extends Thread {
    private String pigName;
    private String material;

    public void buildHouse(int delay) {
        log.info(getPigName() + " started building a house from " + getMaterial());
        try {
            PigThread.sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info(getPigName() + " finished building a house from " + getMaterial());
    }
}
