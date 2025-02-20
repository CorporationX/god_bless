package school.faang.witchergeralt;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
@Getter
@AllArgsConstructor
public class Monster {
    private String name;
    private Location location;
}
