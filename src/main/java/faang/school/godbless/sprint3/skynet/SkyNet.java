package faang.school.godbless.sprint3.skynet;

public class SkyNet {
    public static void main(String[] args) {
        Robot robot = new Robot(10,100);
        Robot robot2 = new Robot(15, 85);

        Thread t1 = new Thread(robot.attack(robot2));
        Thread t2 = new Thread(robot2.attack(robot));
        t1.start();
        t2.start();
    }
}
