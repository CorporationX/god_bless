package faang.school.godbless.BJS2_12371;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Task implements Runnable {

    private String doerName;
    private String task;

    @Override
    public void run() {
        System.out.println(doerName + " начал/а делать задачу " + task + "...");

        // имитация работы
        try {
            Thread.sleep((long)((Math.random() * 31 + 1) * 1000));
        } catch (InterruptedException e) {
            throw new RuntimeException();
        }

        System.out.println(doerName + " закончил/а делать задачу " + task);
    }
}
