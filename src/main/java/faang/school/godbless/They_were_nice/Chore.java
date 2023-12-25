package faang.school.godbless.They_were_nice;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

import java.util.Random;

@AllArgsConstructor
public class Chore implements Runnable {
    private String chore;

    @SneakyThrows
    @Override
    public void run() {
        Random random = new Random();
        System.out.println(Thread.currentThread().getName());
        Thread.sleep(random.nextInt(50000));
        System.out.println(chore + " is done");
    }

}
