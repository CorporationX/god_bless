package faang.school.godbless.multithreading.synchronization_wait_notify.skynet;

public class SkyNet {
    public static void main(String[] args) {
        Target target1 = new Target("M1 Abrams");

        Robot robot1 = new Robot("T1000");
        Robot robot2 = new Robot("T800");

        robot1.setTarget(target1);
        robot2.setTarget(target1);

        Thread thread1 = new Thread(() -> targetOrder(robot1));
        Thread thread2 = new Thread(() -> targetOrder(robot2));

        thread1.start();
        thread2.start();
    }

    public static void targetOrder(Robot robot) {
        try {
            robot.attack();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
