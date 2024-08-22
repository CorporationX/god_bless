package faang.school.godbless.nicePoor;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Chore implements Runnable {
    private String title;

    @Override
    public void run() {
        System.out.println("задача " + title + " начала выполнение в потоке " + Thread.currentThread().getName());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println(title + " прервана, поток: " + Thread.currentThread().getName());
        }
        System.out.println("задача " + title + " закончила выполнение в потоке " + Thread.currentThread().getName());

    }
}
