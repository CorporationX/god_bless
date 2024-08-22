package faang.school.godbless.witcher.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class Monster {
    private final String name;
    private final Location location;
    private final long fightTime;
}
