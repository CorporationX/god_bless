package school.faang.sprint3.task_48392;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.SneakyThrows;

import java.time.LocalDateTime;

@EqualsAndHashCode
@AllArgsConstructor
@Getter
public class RocketLaunch {

    private final String name;
    private final LocalDateTime launchTime;

    @SneakyThrows
    public void launch() {
        Thread.sleep(1000);
        System.out.println("Launching " + name);
    }
}
