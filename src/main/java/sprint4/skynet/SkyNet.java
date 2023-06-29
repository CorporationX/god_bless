package sprint4.skynet;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SkyNet {
    public static void main(String[] args) {
        Robot ivan = new Robot("Ivan");
        Robot robotA = new Robot(ivan, "Glory");
        Robot robotB = new Robot(ivan, "Dark");

        ExecutorService service = Executors.newFixedThreadPool(2);
        service.execute(robotA);
        service.execute(robotB);

        service.shutdown();
    }
}
