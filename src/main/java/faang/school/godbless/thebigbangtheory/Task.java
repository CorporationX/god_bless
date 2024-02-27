package faang.school.godbless.thebigbangtheory;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Task implements Runnable {
    private String name;
    private String task;

    @Override
    public void run() {
        System.out.println(name + " starts: " + task);
        try {
            int time = (int) (Math.random() * 2000) + 1000;
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name + " ends: " + task);
    }
}
