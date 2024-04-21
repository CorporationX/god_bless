package faang.school.godbless.uizly;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Chore implements Runnable{
    private String chore;

    @Override
    public void run() {
        System.out.println("Задача " + chore + " выполняется в потоке " + Thread.currentThread().getName());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println(chore + " прервался в " + Thread.currentThread().getName());
            return;
        }
        System.out.println("Задача " + chore + " завершилась в потоке " + Thread.currentThread().getName());
    }
}
