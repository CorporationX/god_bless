package faang.school.godbless.multithreading.synchronization_wait_notify.skynet;

public class SkyNet {
    public static void main(String[] args) {

        var target1 = "target1";

        Robot robot1 = new Robot(1, "target1");
        Robot robot2 = new Robot(2, "target2");

        Thread thread1 = new Thread(() -> robot1.attack());
        Thread thread2 = new Thread(() -> robot2.attack());

        thread1.start();
        thread2.start();
    }
}
