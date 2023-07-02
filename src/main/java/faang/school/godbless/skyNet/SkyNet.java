package faang.school.godbless.skyNet;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SkyNet {
    public static void main(String[] args) {
        Robot robot1 = new Robot("bus");
        Robot robot2 = new Robot("car");

        Runnable operation1 = () -> robot1.attack();
        Runnable operation2 = () -> robot2.attack();
        new Thread(operation1).start();
        new Thread(operation2).start();

        synchronized (robot1) {
            robot1.attack();
        }
        synchronized (robot2) {
            robot2.attack();
        }
    }
}
