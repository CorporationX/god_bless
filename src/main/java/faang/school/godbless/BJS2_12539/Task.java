package faang.school.godbless.BJS2_12539;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Task implements Runnable {
    private String name;
    private String task;

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            System.out.println(name + " начинает выполнять задание: " + task);
        } catch (InterruptedException e) {
            System.out.println("Задача прервана");
            throw new RuntimeException(e);
        }
        System.out.println(name + " завершил задание: " + task);
    }
}
