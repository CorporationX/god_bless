package faang.school.godbless.SpcaeXSpaceProgramm;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class RocketLaunch {
    private String name;
    private LocalDateTime startTime;

    public void launch()
    {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Launching " + name);

    }
}
