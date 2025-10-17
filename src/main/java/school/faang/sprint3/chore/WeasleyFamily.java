package school.faang.sprint3.chore;


import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@RequiredArgsConstructor
public class WeasleyFamily {
    private final List<String> chores;
    private final ExecutorService executorService = Executors.newCachedThreadPool();

    public void startChores() {
        chores.stream()
                .map(Chore::new)
                .forEach(executorService::execute);

        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(5, TimeUnit.MINUTES)) {
                System.out.println("Не все задачи завершены в указанный период времени.");
            }
        } catch (InterruptedException e) {
            System.out.println("Ожидание выполнения задач было прервано.");
        }
    }
}
