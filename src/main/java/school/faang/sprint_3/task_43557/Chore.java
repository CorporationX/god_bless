package school.faang.sprint_3.task_43557;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Chore implements Runnable {
    private String chore;
public record Chore(String chore) implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " выполняет: " + chore);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("Задача " + chore + " прервана...");
        }
        System.out.println("Задача " + chore + " выполнена!");
    }
}
