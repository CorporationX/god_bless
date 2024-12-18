package school.faang.nicebutpoor;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Chore implements Runnable {
    private static final int SLEEP_TIME = 5000;

    private final String chore;

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " выполняет задачу " + chore);
        try {
            Thread.sleep(SLEEP_TIME);
            System.out.println(chore + " выполнена!");
        } catch (InterruptedException e) {
            System.out.println(chore + " была прервана :(");
        }
    }
}
