package faang.school.godbless.task.fingerPath;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString(onlyExplicitlyIncluded = true)
public class Monster {
    @ToString.Include
    private String name;
    private Location location;
}
