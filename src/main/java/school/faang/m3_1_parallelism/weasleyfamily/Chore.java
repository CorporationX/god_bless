package school.faang.m3_1_parallelism.weasleyfamily;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Chore implements Runnable {
    private final String chore;

    @Override
    public void run() {
        try {
            Thread.currentThread().setName(chore);
            Thread.sleep(1000);
            System.out.println("Выполнена задача: " + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
