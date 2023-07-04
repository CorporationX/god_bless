package faang.school.godbless.Sprint4.Task_13_SkyNet;

public class SkyNet {
    public static void main(String[] args) {
        String newTarget = "The same target for both robots";
        Robot robot1 = new Robot(newTarget);
        Robot robot2 = new Robot(newTarget);

        Thread thread1 = new Thread(() -> {
            robot1.attack();
        });

        Thread thread2 = new Thread(() -> {
            robot2.attack();
        });

        thread1.start();
        thread2.start();
    }
}
