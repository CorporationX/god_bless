package faang.school.godbless.BJS2_3188;

import lombok.Data;
import lombok.NonNull;
import lombok.SneakyThrows;

import java.util.Random;

@Data
public class Chore implements Runnable {
    @NonNull
    private String chore;

    @SneakyThrows
    @Override
    public void run() {
        System.out.println("Task " + chore + " starts in thread " + Thread.currentThread().getName());
        Thread.sleep((new Random().nextInt(4) + 1) * 1000);
        System.out.println("Task " + chore + " finished in thread " + Thread.currentThread().getName());

    }
}
