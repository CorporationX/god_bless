package multithreading.thebigbangtheory;

import lombok.AllArgsConstructor;

//Не знаю как довести до конца задачу, помощи в help не дождался

@AllArgsConstructor
public class Task implements Runnable {

    private String name;
    private String task;


    @Override
    public void run() {
        System.out.println("Task " + task + " was started");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            System.out.println("Work was interrupted!");
        }
        System.out.println(Thread.getAllStackTraces() + " Work was successfully done.");
    }
}