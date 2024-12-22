package school.faang.task_48721;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Chore implements Runnable{
    private String chore;

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        System.out.println("Выполняем задачу: " + chore);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Закончили выполнять задачу: " + chore);
    }
}
