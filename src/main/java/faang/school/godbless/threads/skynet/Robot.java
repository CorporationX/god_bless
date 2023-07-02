package faang.school.godbless.threads.skynet;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Robot implements Runnable {
    private String name;
    private final Target target;

    public void attack() {
        synchronized (target) {
            System.out.printf("Робот %s атакует %s\n", name, target.getName());
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.printf("Цель %s поражена роботом %s\n", target.getName(), name);
        }
    }

    @Override
    public void run() {
        attack();
    }
}
