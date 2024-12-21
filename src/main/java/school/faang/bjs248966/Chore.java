package school.faang.bjs248966;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Chore implements Runnable {

    public static final int WORK_TIME = 1000;
    private String chore;

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " выполняет задачу: " + chore);
            Thread.sleep(WORK_TIME);
            System.out.println(chore + " выполнена!");
        } catch (InterruptedException e) {
            System.out.println("Задача " + chore + " была прервана.");
        }
    }
}
