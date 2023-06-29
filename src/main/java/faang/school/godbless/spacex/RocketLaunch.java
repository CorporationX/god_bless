package faang.school.godbless.spacex;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class RocketLaunch implements Runnable {
    private String name;
    private LocalDateTime date;

    public void launch() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println(getName() + " готовится к запуску");
        Thread.sleep(2000);
        System.out.println(getName() + " запущена " + getDate());

    }

    public void planRocketLaunches(List<RocketLaunch> rocketLaunches) throws InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (RocketLaunch rocketLaunch : rocketLaunches) {
            executorService.submit(rocketLaunch);
        }
        executorService.shutdown();
    }

    @Override
    public void run() {
        try {
            launch();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
