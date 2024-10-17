package school.faang.big.bang.theory;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Slf4j
public class BigBangTheory {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(4);
        Task theoryPreparation = new Task("Шелдон", "подготовка теории");
        Task experimentalDesign = new Task("Леонард", "моделирование эксперимента");
        Task instrumentDevelopment = new Task("Говард", "разработка инструментов");
        Task dataAnalysis = new Task("Раджеш", "анализ данных");
        List<Task> tasks = new ArrayList<>(List.of(
                theoryPreparation,
                experimentalDesign,
                instrumentDevelopment,
                dataAnalysis));
        List<Future<?>> futures = new ArrayList<>();
        tasks.forEach(task -> futures.add(executor.submit(task)));
        futures.forEach(future -> {
            try {
                future.get();
                System.out.println();
            } catch (InterruptedException | ExecutionException e) {
                log.error(e.getMessage());
                log.error(Arrays.toString(e.getStackTrace()));
            }
        });
        executor.shutdown();
    }
}
