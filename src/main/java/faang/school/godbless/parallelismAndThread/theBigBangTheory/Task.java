package faang.school.godbless.parallelismAndThread.theBigBangTheory;

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
        System.out.println(name + " начал(а) выполнять задание: " + task);

        try {
            Thread.sleep((long) (Math.random() * 7000) + 2000);
        } catch (InterruptedException e) {
            System.out.println("Прервано исполнение задания: " + task + ". Исполнитель: " + name);
            return;
        }

        System.out.println(name + " завершил(а) выполнение задания: " + task);
    }
}
