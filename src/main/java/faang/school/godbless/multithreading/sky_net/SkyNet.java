package faang.school.godbless.multithreading.sky_net;

public class SkyNet {
    public static void main(String[] args) {
        Target target1 = new Target("Enemy 1");
        Target target2 = new Target("Enemy 2");
        Robot robot1 = new Robot("Robot 1", target1);
        Robot robot2 = new Robot("Robot 2", target2);

        new Thread(robot1).start();
        new Thread(robot2).start();
    }
}
