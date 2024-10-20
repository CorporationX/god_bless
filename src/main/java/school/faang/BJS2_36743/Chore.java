package school.faang.BJS2_36743;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Chore implements Runnable {
    private final String chore;

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " выполняет задачу: " + chore);
        try {
            Thread.sleep((int) (Math.random() * 3500));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " завершил работу: " + chore);
    }
}
