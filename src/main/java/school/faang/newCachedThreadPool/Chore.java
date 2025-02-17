package school.faang.newCachedThreadPool;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Chore implements Runnable {
    private String chore;

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " поток выполняет задачу: " + chore);
            Thread.sleep(2000);
            System.out.println(chore + "выполнена ");
        } catch (InterruptedException e) {
            System.out.println("задача: " + chore + "была прервана");
            throw new RuntimeException(e);
        }
    }
}