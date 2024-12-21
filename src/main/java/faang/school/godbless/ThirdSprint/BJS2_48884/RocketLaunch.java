package faang.school.godbless.ThirdSprint.BJS2_48884;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class RocketLaunch{
    private String name;
    private LocalDateTime launchTime;

    public RocketLaunch launch(){

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Ракета: " + name + " запущена, время запуска: " + launchTime);
        return this;
    }
}
