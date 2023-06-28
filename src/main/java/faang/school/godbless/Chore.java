package faang.school.godbless;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

import java.util.Random;

@AllArgsConstructor
public class Chore implements Runnable {
    private String chore;

    @SneakyThrows
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " - " + chore);
        Thread.sleep(new Random().nextInt(1000, 5000));
        System.out.println(Thread.currentThread().getName() + " has done");
    }
}
