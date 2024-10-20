package school.faang.BJS2_36743;

import lombok.Getter;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Getter
public class WeasleyFamily {
    private final List<String> chores = List.of(
        "помыть посуду",
        "подмести пол",
        "приготовить ужин",
        "накормить сову",
        "постирать одежду"
    );

    public void startChores() {
        ExecutorService executor = Executors.newCachedThreadPool();
        for (String chore : chores) {
            executor.submit(new Chore(chore));
        }
        executor.shutdown();
    }
}
