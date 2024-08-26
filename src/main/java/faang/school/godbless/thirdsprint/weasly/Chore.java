package faang.school.godbless.thirdsprint.weasly;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Chore implements Runnable {
    private String chore;

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " выполняет задачу: " + chore);
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + " завершил задачу: " + chore);
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " прерван при выполнении задачи: " + chore);
            throw new RuntimeException(e);
        }
    }
}
