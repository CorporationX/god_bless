package faang.school.godbless.thirdsprint.bigbang;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Task implements Runnable {
    private final String name;
    private final String task;

    @Override
    public void run() {
        try {
            System.out.println(name + " начинает выполнять задание: " + task);
            Thread.sleep(2000);
            System.out.println(name + " завершил выполнение задания: " + task);
        } catch (InterruptedException e) {
            System.out.println(name + " прерван во время выполнения задания: " + task);
        }
    }
}
