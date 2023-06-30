package faang.school.godbless.thirdSprint.SkyNet;

import net.jcip.annotations.ThreadSafe;

import java.util.Random;

@ThreadSafe
public record Robot(String name, String target) {
    public synchronized void attack() {
        Random random = new Random();

        System.out.println("Робот " + name + " начинает атаковать цель " + target);
        double killTime = random.nextInt(5000);
        try {
            Thread.sleep((long) killTime);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Цель " + target + " была уничтожена за " + (killTime / 1000) + " секунд");
    }
}
