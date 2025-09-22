package school.faang.multithreading.parallelism.bjs2_89686;

import lombok.Getter;

@Getter
public class WeasleyFamily {

    private final Chore[] chores = {
            new Chore("помыть посуду"),
            new Chore("подмести пол"),
            new Chore("приготовить ужин")
    };
}