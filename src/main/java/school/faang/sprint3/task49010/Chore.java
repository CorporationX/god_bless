package school.faang.sprint3.task49010;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.SneakyThrows;

@AllArgsConstructor
@Getter
public class Chore implements Runnable {
    private final String chore;
    private final long timeInSeconds;

    @SneakyThrows
    @Override
    public void run() {

        System.out.println("Thread " + Thread.currentThread().getName() + " begin to work on : " + chore);
        Thread.sleep(timeInSeconds * 1000L / 4);
        System.out.println(chore + ": 25% done...");
        Thread.sleep(timeInSeconds * 1000L / 4);
        System.out.println(chore + ": 50% done...");
        Thread.sleep(timeInSeconds * 1000L / 4);
        System.out.println(chore + ": 75% done...");
        Thread.sleep(timeInSeconds * 1000L / 4);
        System.out.println("Work " + chore + " done in " + timeInSeconds + " secs!");
    }
}
