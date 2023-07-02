package faang.school.godbless.thirdSprint.TheBigBangTheory;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Task implements Runnable {
    private String name;
    private String task;

    @Override
    public void run() {
        try {
            System.out.println(name + " начал выполнять задачу '" + task + "'");
            Thread.sleep(1000);
            System.out.println(name + " выполнил свою задачу");
        } catch (InterruptedException e) {
            System.out.println("Поток был прерван");
        }
    }
}
