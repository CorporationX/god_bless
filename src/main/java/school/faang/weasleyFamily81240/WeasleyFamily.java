package school.faang.weasleyFamily81240;

import lombok.Getter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    @Getter
    private static Chore[] chores = {
            new Chore("помыть посуду"),
            new Chore("подмести пол"),
            new Chore("приготовить ужин")};
}
