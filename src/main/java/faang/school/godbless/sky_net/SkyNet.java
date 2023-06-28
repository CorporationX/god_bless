package faang.school.godbless.sky_net;

public class SkyNet {
    public static void main(String[] args) {
        Robot robot1 = new Robot("John Connor");
        Robot robot2 = new Robot("T-800");
        Thread thread1 = new Thread(robot1 :: attack);
        Thread thread2 = new Thread(robot2 :: attack);
        thread1.start();
        thread2.start();
    }
}
