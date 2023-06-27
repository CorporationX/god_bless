package faang.school.godbless.sprint4.multithreading_parallelism_thread.task11;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

import java.time.LocalDateTime;

@AllArgsConstructor
public class RocketLaunch implements Runnable {

    private String name;

    private LocalDateTime startDate;

    @SneakyThrows
    public void launch() {
        System.out.println("Ракета " + name + " запущена в " + startDate);
        Thread.sleep(1000);
    }

    @Override
    public void run() {
        long startTime = System.currentTimeMillis();
        launch();
        long endTime = System.currentTimeMillis();
        System.out.println("Затрачено "+ (endTime - startTime) / 1000 + " секунд");
    }
}
