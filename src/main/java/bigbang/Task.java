package bigbang;

import java.util.Random;

public class Task implements Runnable {
    private static Random random = new Random();
    private int minDelay = 1000;
    private int maxDelay = 10000;
    @Override
    public void run() {
        try {
            System.out.println(name + " начал " + task);
            int timer = random.nextInt(minDelay, maxDelay);
            Thread.sleep(timer);
            System.out.println(name + " закончил " + task + " за " + timer + " миллисекунд");
        } catch(InterruptedException e){
            System.out.println(name + " был прерван при выполнении задачи: " + task);
        }
    }

    private String name;
    private String task;

    public Task(String name, String task) {
        this.name = name;
        this.task = task;
    }
}
