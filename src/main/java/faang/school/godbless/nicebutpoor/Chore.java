package faang.school.godbless.nicebutpoor;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Chore implements Runnable {
    private String chore;

    public void run() {
        System.out.println(Thread.currentThread().getName() + " начинает выполнение задачи: " + chore);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName() + " завершил выполнение задачи: " + chore);
    }
}
