package school.faang.bjs2_82824;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Student {
    private final String name;
    private int year;
    private int points;

    private final Object lock = new Object();

    public void compiledTask(Task task) {
        synchronized (lock) {
            try {
                Thread.sleep(task.difficulty());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            points += task.reward();
            System.out.printf("Студент: %s выполнил задание: %s и получил %s очков%n",
                    name, task.name(), task.reward());
        }
    }
}
