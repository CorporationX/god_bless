package faang.school.godbless.thirdSprint.SpaceX;

import java.time.LocalDateTime;

public record RocketLaunch(String launchName, LocalDateTime launchTime) {
    public void launch() {
        System.out.println("Начинаем запуск ракеты " + launchName + "! 3..2..");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(launchName + " оторвалась от земли!");
    }
}
