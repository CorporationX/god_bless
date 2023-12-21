package theBigBangTheory_1025;

import lombok.Data;

@Data
public class Task implements Runnable {
    private String name;
    private String task;

    public Task(String name, String task) {
        this.name = name;
        this.task = task;
    }

    @Override
    public void run() {
        Thread.currentThread().setName("Поток для " + name + ": ");
        System.out.println(Thread.currentThread().getName() + " Начинает выполняться задание - " + task);
        try {
            Thread.sleep(5 * 1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Ошибка выполнения задачи - " + task);
        }
        System.out.println("Задание '" + task + "' выполнено");
    }
}