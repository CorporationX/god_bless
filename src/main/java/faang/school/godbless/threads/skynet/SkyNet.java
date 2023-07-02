package faang.school.godbless.threads.skynet;

public class SkyNet {
    public static void main(String[] args) {
        Target target1 = new Target("tank");
        Target target2 = new Target("prigozhin");

        Robot robot1 = new Robot("jeka", target1);
        Robot robot2 = new Robot("putin", target2);
        Robot robot3 = new Robot("putin", target1);

        Thread thread1 = new Thread(robot1);
        Thread thread2 = new Thread(robot2);
        Thread thread3 = new Thread(robot3);

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
