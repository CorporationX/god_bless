package faang.school.godbless.skyNet;

public class SkyNet {
    public static void main(String[] args) {
        Robot robot1 = new Robot("Robot 1", "Target 1", 3);
        Robot robot2 = new Robot("Robot 2", "Target 2", 5);
        Robot robot3 = new Robot("Robot 3", "Target 3", 2);

        Thread thread1 = new Thread(robot1::attack);
        Thread thread2 = new Thread(robot2::attack);
        Thread thread3 = new Thread(robot3::attack);

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
