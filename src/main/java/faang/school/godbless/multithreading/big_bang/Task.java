package faang.school.godbless.multithreading.big_bang;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Task implements Runnable {
    private String name;
    private String task;

    @Override
    public void run() {
        System.out.println(name + " начинает выполнять задание " + task);
        try {
            Thread.sleep(250);
        } catch (InterruptedException e) {
            System.out.println("Выполнение задания было прервано");
            return;
        }
        System.out.println(name + " завершает выполнять задание " + task);
    }
}
