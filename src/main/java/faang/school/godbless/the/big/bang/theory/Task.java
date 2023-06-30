package faang.school.godbless.the.big.bang.theory;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Task implements Runnable {
    private String name;
    private String task;

    @Override
    public void run() {
        System.out.println(name + " started the task: " + task);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}
