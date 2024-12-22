package school.faang.bjs48590;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.SneakyThrows;
import java.util.Random;

@AllArgsConstructor
@Getter
public class Chore implements Runnable {
    private String chore;
    private static final long TEN_SECONDS = 10_000;

    @SneakyThrows
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " выполняет задачу: " + chore);
        Thread.sleep(new Random().nextLong(TEN_SECONDS));
        System.out.println(Thread.currentThread().getName() + " закончил задачу: " + chore);
    }
}
