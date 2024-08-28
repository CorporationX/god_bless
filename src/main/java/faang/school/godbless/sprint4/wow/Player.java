package faang.school.godbless.sprint4.wow;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
public class Player {
    private final String name;
    private int level;
    @Setter
    private int experience;

}
