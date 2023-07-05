package faang.school.godbless.skyNet;

public class SkyNet {
    public static void main(String[] args) {
        Robot robot1 = new Robot("enemy1");
        Robot robot2 = new Robot("enemy2");
        Thread thread1 = new Thread(robot1::attack);
        Thread thread2 = new Thread(robot2::attack);
        thread2.start();
        thread1.start();
    }
}
