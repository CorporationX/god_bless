package faang.school.godbless.sprint4.multithreading_synchronization_wait_notify.task1;

public class SkyNet {

    public static void main(String[] args) {
        Robot robot1 = new Robot("Машина 1");
        Robot robot2 = new Robot("Машина 2");

        Thread thread1 = new Thread(robot1::attack);
        Thread thread2 = new Thread(robot2::attack);

        thread1.start();
        thread2.start();
    }
}
