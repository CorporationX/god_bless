import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.Duration;
import java.time.LocalDateTime;

import static java.time.LocalDateTime.*;


@AllArgsConstructor
@Getter
public class RocketLaunch implements Runnable {
    private String name;
    private LocalDateTime time;

    public void launch() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("Ракета полетела: " + name);
    }

    @Override
    public void run() {
        Duration duration = Duration.between(now(), time);

        try {
            Thread.sleep(duration);
            launch();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
