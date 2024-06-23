package faang.school.godbless.parallelism.wereverynice;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Chore implements Runnable {
    private String chore;

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " " + chore);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException("Поток " + Thread.currentThread().getName() + " был прерван");
        }
    }
}
