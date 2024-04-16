package faang.school.godbless.SpaceX;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class RocketLaunch {
    private static final long LAUNCH_TIME = 1000L;
    private String name;
    private LocalDateTime time;

    public void launch() {
        try {
            Thread.sleep(LAUNCH_TIME);
            System.out.println("Ракета " + name + " запущена!");
        } catch (InterruptedException e) {
            System.out.println("Запуск ракеты " + name + " прерван!");

        }
    }
}
