package school.faang.spring3.task_48523;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Getter
public class WeasleyFamily {
    private final List<Chore> choreList = new ArrayList<>();

    public void doChores() {
        ExecutorService service = Executors.newCachedThreadPool();
        for (Chore chore : choreList) {
            service.execute(chore);
        }
        service.shutdown();

    }
}
