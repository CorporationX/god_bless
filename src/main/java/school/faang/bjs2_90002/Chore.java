package school.faang.bjs2_90002;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Chore implements Runnable {
    String chore;

    @Override
    public void run() {
        System.out.printf("Работает поток %s", Thread.currentThread().getName());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException("Поток не смог уснуть )");
        }


    }
}
