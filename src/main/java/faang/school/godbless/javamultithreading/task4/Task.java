package faang.school.godbless.javamultithreading.task4;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class Task implements Runnable {
    private String name;
    private String task;

    @Override
    public void run() {
        System.out.println(name + " начал выполнять задачу:" + task);
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            System.out.println("Задача прервалась");
            return;
        }
        System.out.println(name + " завершил задачу: " + task);
    }
}
