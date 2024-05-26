package faang.school.godbless.skyNet;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SkyNet {
    public static void main(String[] args) {
        Robot robot1 = new Robot("bus");
        Robot robot2 = new Robot("bus");

        new Thread(() -> robot1.attack()).start();
        new Thread(() -> robot2.attack()).start();
    }
}
