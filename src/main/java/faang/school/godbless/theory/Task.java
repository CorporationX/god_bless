package faang.school.godbless.theory;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Task implements Runnable {
    private String name;
    private String task;

    @Override
    public void run() {
        System.out.println(name + " начинает выполнять " + task);
        try {
            System.out.println(name + " Выполняет задание " + task);
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException("Метод был прерван...");
        }
        System.out.println(name + " Выполнил задание " + task);
    }
}
