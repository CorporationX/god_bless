package faang.school.godbless.multithreading.synchronization_wait_notify.skynet;

public class Robot {
    private String model;
    private Target target;

    public Robot(String model) {
        this.model = model;
    }

    public void attack() {
        System.out.println("Robot " + model + " attack " + target.getName());
        if (!target.isStatus()) throw new IllegalArgumentException(target.getName() + " already is destroyed");
        target.setStatus(false);
        System.out.println("Robot " + model + " destroyed " + target.getName());
    }

    public void setTarget(Target target) {
        this.target = target;
    }
}
