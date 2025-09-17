package school.faang.bjs2_90002;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    Chore[] chores = {new Chore("Решить эту задачу."),
            new Chore("Решить еще 3 задачи по этой теме."),
            new Chore("Изучить Synchronized."),
            new Chore("Решить не менее 4 задач по Synchronized.")};

    Executor executor = Executors.newCachedThreadPool();
    for (Chore tast : chores)



}
