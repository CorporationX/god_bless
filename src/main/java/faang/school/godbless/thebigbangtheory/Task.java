package faang.school.godbless.thebigbangtheory;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Random;


@Getter
public class Task implements Runnable {
    private String name;
    private String task;
    private int leadTime = new Random().nextInt(10000);

    Task(String name, String task) {
        this.name = name;
        this.task = task;
    }

    @Override
    public void run() {
        String nametask = getTask();
        System.out.println(getName() + "ом начато выполнение задания " + nametask);

        try {
            Thread.sleep(leadTime);
        } catch (InterruptedException e) {
            System.out.println("Выполнение задачи было прервано");
            throw new RuntimeException(e);
        }
        System.out.println("Выполнение задания " + nametask + " окончено," + " время выполнения: " + leadTime / 1000 + "сек");
    }
}
