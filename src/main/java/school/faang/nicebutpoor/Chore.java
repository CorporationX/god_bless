package school.faang.nicebutpoor;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Chore implements Runnable {
    private final String chore;

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " выполняет задачу " + chore);
        try {
            Thread.sleep(5000);
            System.out.println(chore + " выполнена!");
        } catch (InterruptedException e) {
            System.out.println(chore + " была прервана :(");
        }
    }
}
