package school.faang.bjs_50017;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
public class Player {
    private final String name;
    private final int level;
    @Setter
    private int experience;
}
