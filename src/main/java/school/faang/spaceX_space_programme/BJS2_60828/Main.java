package school.faang.spaceX_space_programme.BJS2_60828;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
public class Main {
    public static void main(String[] args) {
        LaunchPad launchPad = new LaunchPad();

        List<RocketLaunch> rockets = List.of(
                new RocketLaunch("Сирена", LocalDateTime.now().plusSeconds(3)),
                new RocketLaunch("Аликорн", LocalDateTime.now().plusSeconds(8)),
                new RocketLaunch("Сокол", LocalDateTime.now().plusSeconds(15))
        );

        long startOfLaunch = System.currentTimeMillis();
        launchPad.planRocketLaunches(rockets);
        long endOfLaunch = System.currentTimeMillis();
        log.info("Время выполнения всех запусков {} миллисекунд", (endOfLaunch - startOfLaunch));
    }
}
