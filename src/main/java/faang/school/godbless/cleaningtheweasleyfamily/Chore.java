package faang.school.godbless.cleaningtheweasleyfamily;

import lombok.RequiredArgsConstructor;

import java.util.Random;

@RequiredArgsConstructor
public class Chore implements Runnable {
    private  final String chore;
    private Random random = new Random();

    @Override
    public void run() {

        System.out.println("Задача " + chore + " Обрабатывается в " + Thread.currentThread().getName());
        try {
            Thread.sleep(random.nextInt(1_0000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Задача " + chore + " выполнена.");
    }
}
