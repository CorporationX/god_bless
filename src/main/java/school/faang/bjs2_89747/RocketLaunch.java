package school.faang.bjs2_89747;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

@Slf4j
@Getter
@AllArgsConstructor
public class RocketLaunch {
    private final String name;
    private final LocalDateTime launchTime;
}
