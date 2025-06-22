package school.faang.weasleyfamily81240;

import lombok.Getter;

public class WeasleyFamily {
    @Getter
    private static Chore[] chores = {
            new Chore("помыть посуду"),
            new Chore("подмести пол"),
            new Chore("приготовить ужин")};
}
