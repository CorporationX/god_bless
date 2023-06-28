package skyNet;

public class SkyNet {
    public static void main(String[] args) {
        Robot robot1 = new Robot("T-800", new Target("Sara Connor"));
        Robot robot2 = new Robot("T-1000", new Target("John Connor"));

        Thread thread1 = new Thread(robot1::attack);
        Thread thread2 = new Thread(robot2::attack);

        thread1.start();
        thread2.start();
    }
}
