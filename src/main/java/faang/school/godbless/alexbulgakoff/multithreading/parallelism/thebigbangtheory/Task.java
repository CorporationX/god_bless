package faang.school.godbless.alexbulgakoff.multithreading.parallelism.thebigbangtheory;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * @author Alexander Bulgakov
 */
@AllArgsConstructor
@Getter
@ToString
public class Task implements Runnable {

    private String name;
    private String task;
    @Override
    public void run() {
        System.out.println("Выполнение задания началось!");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Задание " + getTask() + " выполнено!");
    }
}
