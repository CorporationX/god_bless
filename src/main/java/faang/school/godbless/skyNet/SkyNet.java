package faang.school.godbless.skyNet;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SkyNet {
    public static void main(String[] args) {
        Robot robot1 = new Robot("John Conor");
        Robot robot2 = new Robot("Sara Conor");

        Thread thread1 = new Thread(robot1::attack);
        Thread thread2 = new Thread(robot2::attack);
        thread1.start();
        thread2.start();
    }
}
