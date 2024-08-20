package faang.school.godbless.BJS2_24074;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Chore implements Runnable {

    private final String chore;

    @Override
    public void run() {
        System.out.println("Поток " + Thread.currentThread().getName() + " начал " + chore);

        try {
            Thread.sleep(10000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
