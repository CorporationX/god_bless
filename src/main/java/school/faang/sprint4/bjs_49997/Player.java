package school.faang.sprint4.bjs_49997;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class Player {
    private final String name;
    private final int level;
    @Setter
    private int experience;
}
