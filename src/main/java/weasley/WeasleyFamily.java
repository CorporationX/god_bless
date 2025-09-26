package weasley;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class WeasleyFamily {
    String [] chores = {};
    ExecutorService pool =  Executors.newCachedThreadPool();

    public WeasleyFamily(String[] chores) {
        this.chores = chores;
    }

    public void doTasks() {
        for (String task : chores) {
            Chore chore = new Chore(task);
            pool.submit((chore));
        }
        pool.shutdown();
    }
}
