package faang.school.godbless.multithreading.skynet;

public class Skynet {
    public static void main(String[] args) throws InterruptedException {
        Target target1 = new Target("Human");
        Robot robot1 = new Robot("T1000", target1);
        Robot robot2 = new Robot("T800", target1);
        Thread thread1 = new Thread(robot1);
        Thread thread2 = new Thread(robot2);

        thread1.start();
        thread2.start();
    }
}
