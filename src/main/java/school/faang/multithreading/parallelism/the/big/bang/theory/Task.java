package school.faang.multithreading.parallelism.the.big.bang.theory;

import java.util.Random;

public class Task implements Runnable {
    private String name;
    private String task;

    private Random random = new Random();

    public Task(String name, String task) {
        this.name = name;
        this.task = task;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " - " + name + " начал делать задачу " + task);
        try {
            Thread.sleep(random.nextInt(10000) + 3000);
            System.out.println(Thread.currentThread().getName() + " - " + name + " выполнил задачу " + task);
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " - " + name + " не выполнил задачу " + task);
        }
    }
}
