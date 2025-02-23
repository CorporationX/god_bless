package school.faang.naughtwoBJS260907;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class Monster {
    private final String name;
    @Setter private Location location;
}
