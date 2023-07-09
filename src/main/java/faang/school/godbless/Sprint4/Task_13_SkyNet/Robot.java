package faang.school.godbless.Sprint4.Task_13_SkyNet;

public class Robot {
    private final String target;
    private final Object lock;

    public Robot(String target) {
        this.target = target;
        this.lock = new Object();
    }

    public void attack() {
        synchronized (lock) {
            System.out.println("Robot " + Thread.currentThread().getName() + " is attacking target: " + target);
        }
    }
}