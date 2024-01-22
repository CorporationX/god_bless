package faang.school.godbless.alexbulgakoff.multithreading.parallelism.spacex;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.SneakyThrows;
import lombok.ToString;

/**
 * @author Alexander Bulgakov
 */
@AllArgsConstructor
@Getter
@ToString
public class RocketLaunch implements Runnable {
    private String launchName;
    private int launchTime;

    @Override
    public void run() {
        launch();
    }

    @SneakyThrows
    public void launch() {
        Thread.sleep(1000);
        System.out.println("Запуск ракеты " + launchName + "!");
    }
}
