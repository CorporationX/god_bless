package faang.school.godbless.BJS2_24950;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
public class Player {
    private final String name;
    private int lvl;
    @Setter
    private int exp;
}
