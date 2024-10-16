package bjs2_36677;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    private List<String> chores;

    public WeasleyFamily(List<String> chores) {
        this.chores = chores;
    }

    public void doChores() {
        ExecutorService service = Executors.newCachedThreadPool();
        chores.forEach(chore -> service.submit(new Chore(chore)));

        service.shutdown();
    }
}
