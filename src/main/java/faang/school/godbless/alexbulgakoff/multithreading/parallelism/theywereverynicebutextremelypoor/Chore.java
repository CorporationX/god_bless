package faang.school.godbless.alexbulgakoff.multithreading.parallelism.theywereverynicebutextremelypoor;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * @author Alexander Bulgakov
 */
@AllArgsConstructor
@Getter
@ToString
public class Chore implements Runnable {

    private String chore;
    @Override
    public void run() {
        System.out.println("Задача " + chore + " выполняется в " + Thread.currentThread().getName());
        try {
            Thread.sleep(400);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Задача " + chore + " выполнена!");
    }
}
