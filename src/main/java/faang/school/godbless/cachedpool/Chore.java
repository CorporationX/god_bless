package faang.school.godbless.cachedpool;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Chore implements Runnable {

    private String chore;

    @Override
    public void run() {
        System.out.println(String.format("Thread \"%s\" starts task \"%s\"", Thread.currentThread().getName(), chore));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
