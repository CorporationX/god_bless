package faang.school.godbless.spacex;

import lombok.AllArgsConstructor;

import java.time.Duration;
import java.time.LocalDateTime;
@AllArgsConstructor
public class RocketLaunch implements Runnable{

    private String name;
    private LocalDateTime launchTime;


    @Override
    public void run() {
        this.planRocketLaunches();
    }

    public void planRocketLaunches(){
        try {
            System.out.println("Getting ready for launch " + name);
            Thread.sleep(Duration.between(LocalDateTime.now(), launchTime).toMillis());
            System.out.println("Launching " + name);
            Thread.sleep(1000);
            System.out.println("Launched " + name);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
