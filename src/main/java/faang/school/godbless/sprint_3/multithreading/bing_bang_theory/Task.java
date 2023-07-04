package faang.school.godbless.sprint_3.multithreading.bing_bang_theory;

import lombok.AllArgsConstructor;

import java.util.Random;

@AllArgsConstructor
public class Task implements Runnable {
    private String name;
    private String task;

    @Override
    public void run() {
        System.out.printf("%s берет на себя задание по %s и начинает делать его....%n", name, task);
        try {
            int workingTime = new Random().nextInt((5) + 1) * 1000;
            Thread.sleep(workingTime);
        } catch (InterruptedException exception) {
            System.out.println("Task interrupted");
            return;
        }
        System.out.printf("Задание %s выполнено успешно%n", task);
    }
}
