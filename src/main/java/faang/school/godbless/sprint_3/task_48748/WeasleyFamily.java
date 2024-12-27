package faang.school.godbless.sprint_3.task_48748;

import lombok.Getter;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Getter
public class WeasleyFamily {
    private final ExecutorService executorService = Executors.newCachedThreadPool();
    private final Chore[] chores = new Chore[]{new Chore("Помыть посуду"), new Chore("Подмести пол"),
            new Chore("Приготовить ужин")};

    public void doChores() {
        Arrays.stream(chores).forEach(executorService::execute);
        executorService.shutdown();
    }
}
