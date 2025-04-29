package school.faang.weasley_pool;

import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Getter
@Setter
public class WeasleyFamily {
    private String[] chores = {"помыть посуду", "подмести пол", "приготовить ужин"};
    private ExecutorService executor = Executors.newCachedThreadPool();

    public void executeChores() {
        for (String chore : this.chores) {
            executor.execute(new Chore(chore));
        }
        executor.shutdown();
    }
}
