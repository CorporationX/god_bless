package faang.school.godbless.multi_paral.task4big_bang;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Task implements Runnable {
    private String name;
    private String task;

    @Override
    public void run() {
        System.out.println(name + " начал выполнение задачи: \"" + task + "\"");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println("Задача прервана");
        }

        System.out.println(name + " выполнил задачу: \"" + task + "\"");
    }
}
