package faang.school.godbless.good_n_poor;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

import java.util.Random;

@AllArgsConstructor
public class Chore implements Runnable {

    private String chore;

    @Override
    @SneakyThrows
    public void run() {
        Thread.sleep(new Random().nextInt(7_000));
        System.out.println(chore + " is done, by" + Thread.currentThread().getName());
    }
}
