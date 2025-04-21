package school.faang.parallelism_3_1.bjs2_72905;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
@RequiredArgsConstructor
public class WeasleyFamily {
    static final List<String> chores = List.of("помыть посуду", "подмести пол", "приготовить ужин");

    public static void main(String[] args) {
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();

        for (String chore : chores) {
            Chore task = new Chore(chore);
            cachedThreadPool.execute(task);
        }
        cachedThreadPool.shutdown();
        try {
            if (!cachedThreadPool.awaitTermination(5, TimeUnit.MINUTES)) {
                log.warn("Задачи не завершились за 5 минут, принудительно останавливаем...");
                cachedThreadPool.shutdownNow(); // Принудительное завершение, если задачи зависли
            }
        } catch (InterruptedException e) {
            // Если главный поток был прерван во время ожидания, принудительно останавливаем пул
            cachedThreadPool.shutdownNow();
        }
        log.info("Все задачи выполнены!");
    }
}
