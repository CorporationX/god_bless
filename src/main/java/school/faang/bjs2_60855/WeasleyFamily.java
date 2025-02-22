package school.faang.bjs2_60855;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class WeasleyFamily {

    private final Chore[] chores = new Chore[]{
            new Chore("помыть посуду"),
            new Chore("подмести пол"),
            new Chore("приготовить ужин"),
            new Chore("постирать вещи")
    };

}
