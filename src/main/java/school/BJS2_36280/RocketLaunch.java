package school.BJS2_36280;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class RocketLaunch {

    private String name;
    private LocalDateTime launchTime;

    public void launch() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("Запущена ракета: " + name);
    }
}