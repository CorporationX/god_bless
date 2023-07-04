package faang.school.godbless.sprint_3.multithreading.sky_net;

public record Robot(String target) {
    public void attack() {
        synchronized (target) {
            System.out.printf("Target: %s are dead!%n", target);
        }
    }
}