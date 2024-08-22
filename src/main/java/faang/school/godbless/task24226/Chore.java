package faang.school.godbless.task24226;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class Chore implements Runnable{
    private String chore;
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " начал работу.");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName() + " завершил работу.");
    }
}
