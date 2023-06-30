package faang.school.godbless.skynet;

public class SkyNet {
    public static void main(String[] args) {
        Robot robot1 = new Robot("robot1", "Sarah Conor");
        Robot robot2 = new Robot("robot2", "John Conor");

        Thread thread1 = new Thread(robot1::attack);
        Thread thread2 = new Thread(robot2::attack);

        thread1.start();
        thread2.start();
    }
}