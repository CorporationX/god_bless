package school.faang.thirdStream.BJS2_36692;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Task implements Runnable {
    private final String name;
    private final String task;

    @Override
    public void run() {
        System.out.printf("Начало выполнение задачи '%s' научным работником %s%n", task, name);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.printf("Выполнение задачи '%s' научным работником %s было прервано%n", task, name);
            e.printStackTrace();
        }

        System.out.printf("Задача '%s' выполнена%n", task);
    }
}
