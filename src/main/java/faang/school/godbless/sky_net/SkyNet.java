package faang.school.godbless.sky_net;

public class SkyNet {
    public static void main(String[] args) {
        Target target1 = new Target("John Connor");
        Target target2 = new Target("T-800");
        Robot robot1 = new Robot("Т-1000", target1);
        Robot robot2 = new Robot("T-X", target1);
        Thread thread1 = new Thread(robot1 :: attack);
        Thread thread2 = new Thread(robot2 :: attack);
        thread1.start();
        thread2.start();
    }
}
