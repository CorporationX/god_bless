package school.faang.threadpool;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Chore implements Runnable {
    private final String chore;

    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " выполняет: " + chore);
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + " закончил: " + chore);
        } catch (InterruptedException e) {
            System.out.println("Задача была прервана: " + chore);
        }
    }
}
