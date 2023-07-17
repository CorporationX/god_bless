package faang.school.godbless.multithreading.space_x;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class RocketLaunch implements Runnable {
    private String launchName;
    private LocalDateTime lunchDate;

    public void launch() {
        System.out.println("Запуск корабля " + launchName + " на " + lunchDate);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }

        System.out.println("Корабль " + launchName + " запущен в " + lunchDate.plusSeconds(1));
    }

    @Override
    public void run() {
        launch();
    }
}
