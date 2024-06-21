package faang.school.godbless.BJS212350;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

@AllArgsConstructor
public class Task implements Runnable {

    private String name;
    private String task;


    @Override
    public void run() {
        try {
            System.out.println("Начало выполнения " + name + " " + task);
            Thread.sleep(5000);
            System.out.println("Конец выполнения " + name + " " + task);
        } catch (InterruptedException e) {
            System.out.println("Выполнение задачи прервано");
        }
    }
}
