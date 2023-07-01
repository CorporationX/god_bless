package faang.school.godbless.sky_net;

public class SkyNet {
    public static void main(String[] args) {
        Robot robot1 = new Robot("robot1", new Target("target1"));
        Robot robot2 = new Robot("robot2", new Target("target2"));

        Thread thread1 = new Thread(robot1::attack);
        Thread thread2 = new Thread(robot2::attack);

        thread1.start();
        thread2.start();
    }
}
