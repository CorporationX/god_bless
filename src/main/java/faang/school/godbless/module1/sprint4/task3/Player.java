package faang.school.godbless.module1.sprint4.task3;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class Player {
    private String name;
    private int lvl;
    @Setter
    private int experience;
}
