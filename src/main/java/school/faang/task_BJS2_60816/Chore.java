package school.faang.task_BJS2_60816;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Chore implements Runnable {
    private final String title;

    @Override
    public void run() {
        System.out.println("\"" + Thread.currentThread().getName() + "\"" +
                " has just started the chore " + "\"" + title + "\"");
        try {
            Thread.sleep(1000); //имитация выполнения задачи
        } catch (InterruptedException e) {
            System.out.println("The chore " + title + " is interrupted");
        }
        System.out.println("\"" + Thread.currentThread().getName() + "\"" +
                " has just performed " + "\"" + title + "\"");
    }
}