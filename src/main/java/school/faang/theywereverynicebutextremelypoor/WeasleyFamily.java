package school.faang.theywereverynicebutextremelypoor;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class WeasleyFamily {
    private static final List<String> CHORES = List.of("помыть посуду", "подмести пол", "приготовить ужин");
    private static final ExecutorService EXECUTOR = Executors.newFixedThreadPool(3);

    public static void main(String[] args) {
        CHORES.forEach(chore -> EXECUTOR.submit(new Chore(chore)));
        EXECUTOR.shutdown();
        sleep();
    }

    public static void sleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        }
    }
}
