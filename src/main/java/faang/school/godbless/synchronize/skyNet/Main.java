package faang.school.godbless.synchronize.skyNet;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Target target1 = new Target("Цель № 1", 0);
        Robot robot1 = new Robot("Робот № 1", target1);
        Robot robot2 = new Robot("Робот № 2", target1);

        Thread thread1 = new Thread(() -> {
            try {
                robot1.attack();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                robot2.attack();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
    }
}
