package faang.school.godbless.Multithreading.SynchronizationWaitNotify.task01_SkyNet;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SkyNet {
    public static void main(String[] args) {
        Robot robot1 = new Robot("Terminator");
        Robot robot2 = new Robot("Terminator");

        Thread thread1 = new Thread(() -> robot1.attack());
        Thread thread2 = new Thread(() -> robot2.attack());

        thread1.start();
        thread2.start();
    }
}
