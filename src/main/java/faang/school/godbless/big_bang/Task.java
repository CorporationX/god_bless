package faang.school.godbless.big_bang;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Task implements Runnable {
    private String name;

    private String task;

    @Override
    public void run() {
        System.out.println(name + " начал выполнение задачи: " + task);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException("Задача прервана");
        }
        System.out.println("Конец выполнения задачи: " + task);
    }
}
