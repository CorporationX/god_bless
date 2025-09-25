package school.faang.bjs2_89561;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Task implements Runnable {

    private String name;
    private String task;

    @Override
    public void run() {
        System.out.println("Task " + task + " has been started by " + name);
        try {
            Thread.sleep(2000);
            System.out.println("Task " + task + " has been completed by " + name);
        } catch (InterruptedException e) {
            System.out.println(name + " has interrupted task " + task);
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }
}
