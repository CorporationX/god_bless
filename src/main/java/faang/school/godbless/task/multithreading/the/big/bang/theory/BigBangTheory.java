package faang.school.godbless.task.multithreading.the.big.bang.theory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class BigBangTheory {
    private final static int TOTAL_PULL_SIZE = 4;
    private final static int TIME_LIMIT = 2;

    private final static Logger logger = LoggerFactory.getLogger(BigBangTheory.class);

    public static void main(String[] args) {
        List<List<String>> tasks = List.of(
                List.of("Шелдон", "подготовка теории"),
                List.of("Леонард", "моделирование эксперимента"),
                List.of("Говард", "разработка инструментов"),
                List.of("Раджеш", "анализ данных")
        );
        ExecutorService executorService = Executors.newFixedThreadPool(TOTAL_PULL_SIZE);
        IntStream.range(0, tasks.size())
                .forEach(i -> {
            executorService.submit(() -> new Task(tasks.get(i).get(0), tasks.get(i).get(1)).run());
        });
        executorService.shutdown();
        try {
            if (executorService.awaitTermination(TIME_LIMIT, TimeUnit.MINUTES)) {
                logger.info("\nПроект завершен!");
            } else {
                logger.warn("Парни не успели завершить проект в срок за %s минуты".formatted(TIME_LIMIT));
            }
        } catch (InterruptedException exception) {
            logger.error("Interrupted exception: {}", exception.getMessage());
        }
    }
}
