package faang.school.godbless.big_bang_boom;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BigBangTheory {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        Task sheldonTask = new Task("Sheldon", "theory preparation");
        Task leonardTask = new Task("Leonard", "experiment simulation");
        Task govardTask = new Task("Govard", "develop tools");
        Task radzheshTask = new Task("Radzhesh", "data analysis");

        executorService.execute(sheldonTask);
        executorService.execute(leonardTask);
        executorService.execute(govardTask);
        executorService.execute(radzheshTask);  // Я запускал и с submint там тоже также работает! Пpочитал в чем их отличие!
        // что предпотительней использовать? или всегда используется submint?
        executorService.shutdown();
    }
}


@Data
@AllArgsConstructor
class Task implements Runnable {
    private String name;
    private String task;

    @Override
    public void run() {
        System.out.println(name + " Начал делать задание: " + task);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException("Задача прервана", e);
        }
    }
}