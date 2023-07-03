package faang.school.godbless.multithreading.synchronization_wait_notify.skynet;

public class Robot {
    private int id;
    private String target;

    public Robot(int id, String target) {
        this.id = id;
        this.target = target;
    }

    public synchronized void attack() {
        System.out.println("Robot " + id + " attack " + target);
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Robot " + id + " destroyed " + target);
    }
}
