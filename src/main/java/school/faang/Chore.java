package school.faang;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Chore implements Runnable {
    private final String task;

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " выполняет задачу " + task);
            Thread.sleep(1000);
            System.out.println(task + " задача выполнена.");
        } catch (InterruptedException e) {
            System.out.println("Задача " + task + "была прервана");
            Thread.currentThread().interrupt();
        }
    }

}
