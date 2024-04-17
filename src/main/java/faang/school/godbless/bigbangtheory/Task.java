package faang.school.godbless.bigbangtheory;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Task implements Runnable {

    private String name;
    private String task;

    @Override
    public void run() {
        System.out.println("Задача: " + task + "натача, исполнитель: " + name);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {

        }
    }
}
