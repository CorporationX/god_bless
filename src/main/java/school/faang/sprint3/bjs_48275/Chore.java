package school.faang.sprint3.bjs_48275;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Chore implements Runnable {
    private final String chore;

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " выполняет задачу: " + chore);
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + " завершил выполнение задачи: " + chore);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
