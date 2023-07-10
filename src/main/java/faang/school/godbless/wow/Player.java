package faang.school.godbless.wow;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class Player {

    private String name;
    @Setter
    private int level;
    @Setter
    private int experience;
}
