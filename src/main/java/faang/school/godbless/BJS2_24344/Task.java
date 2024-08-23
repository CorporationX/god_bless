package faang.school.godbless.BJS2_24344;

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
        try {
            System.out.println(getName() + " начал выполнять задание: " + getTask());
            Thread.sleep(2000);
            System.out.println(getName() + " выполнил своё задание!");
        } catch (InterruptedException e) {
            System.out.println("Задача прервалась!");
            Thread.currentThread().interrupt();
        }
    }
}
