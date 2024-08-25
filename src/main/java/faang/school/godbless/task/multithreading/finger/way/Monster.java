package faang.school.godbless.task.multithreading.finger.way;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Monster {
    private final String name;
    private final Location location;
    private final long timeToKill;
}
