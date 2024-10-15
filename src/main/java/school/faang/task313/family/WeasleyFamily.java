package school.faang.task313.family;

import lombok.Data;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Data
public class WeasleyFamily {
    private String[] chores = new String[]{"помыть посуду", "подмести пол", "приготовить ужин"};
    private ExecutorService service = Executors.newCachedThreadPool();
}
