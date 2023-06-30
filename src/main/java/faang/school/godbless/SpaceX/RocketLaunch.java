package faang.school.godbless.SpaceX;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.Duration;
import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class RocketLaunch implements Runnable{

    private String name;
    private LocalDateTime launchTime;

    public void launch() {
//        System.out.println(Duration.between(launchTime, LocalDateTime.now()).toMillis());

        try {
            Thread.sleep(Duration.between(LocalDateTime.now(), launchTime).toMillis());
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Ракета " + name + " запущена успешно");
    }

    @Override
    public void run() {
        this.launch();
    }
}
