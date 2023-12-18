package faang.school.godbless.multi_paral.task5very_nice;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Chore implements Runnable {
    private String name;

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " начинает выполнение задачи: " + name);
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + " завершил выполнение задачи: " + name);
        } catch (InterruptedException e) {
            System.out.println("Задача была прервана: " + name);
        }
    }
}
