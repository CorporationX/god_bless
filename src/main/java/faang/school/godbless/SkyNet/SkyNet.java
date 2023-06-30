package faang.school.godbless.SkyNet;

public class SkyNet {
    public static void main(String[] args) {
        Robot robot1 = new Robot("Target1");
        Robot robot2 = new Robot("Target2");

        Thread thread1 = new Thread(robot1::attack);
        Thread thread2 = new Thread(robot2::attack);

        thread1.start();
        thread2.start();
    }
}
