package faang.school.godbless.BJS2_3187;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.SneakyThrows;

import java.util.Random;

@Data
@AllArgsConstructor
public class Task implements Runnable {
    @NonNull
    private String name;
    @NonNull
    private String task;

    @SneakyThrows
    @Override
    public void run() {
        var randomGenerator = new Random();
        System.out.println(name + " starts " + task);
        Thread.sleep((randomGenerator.nextInt(4) + 1) * 1000);
        System.out.println(name + " completes " + task);
    }
}
