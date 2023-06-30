package faang.school.godbless.multithreading.skynet;

import lombok.AllArgsConstructor;


@AllArgsConstructor
public class Robot implements Runnable {
    private String name;
    private final Target target;

    public void attack() {
        synchronized (target) {
            System.out.printf("%s is attacking %s (%s)\n",
                    name, target.getName(), Thread.currentThread().getName());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.printf("%s killed %s (%s)\n",
                    name, target.getName(), Thread.currentThread().getName());
        }
    }

    @Override
    public void run() {
        attack();
    }
}
