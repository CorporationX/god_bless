package school.faang.sprint_3.task_48297;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    public static void main(String[] args) {
        List<String> chores = List.of("помыть посуду", "сделать уроки", "выкинуть мусор", "приготовить ужин");
        ExecutorService service = Executors.newCachedThreadPool();
        chores.forEach(chore -> service.submit(new Chore(chore)));
        service.shutdown();
    }
}
