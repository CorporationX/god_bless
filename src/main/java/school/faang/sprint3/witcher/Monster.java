package school.faang.sprint3.witcher;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class Monster {
    private final String name;
    private final Location location;
}
