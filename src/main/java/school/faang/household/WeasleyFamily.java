package school.faang.household;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class WeasleyFamily {
    public static void main(String[] args) {
        String[] chores = {
                "помыть посуду",
                "подмести пол",
                "приготовить ужин",
                "протереть пыль",
                "постирать",
                "полить цветы",
                "погладить"
        };

        try (ExecutorService executor = Executors.newCachedThreadPool()) {
            for (String chore : chores) {
                executor.execute(new Chore(chore));
            }
            executor.shutdown();
        }

        log.info("Все задачи выполнены.");
    }
}
