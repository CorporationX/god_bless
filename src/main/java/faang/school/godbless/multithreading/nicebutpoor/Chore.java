package faang.school.godbless.multithreading.nicebutpoor;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Chore implements Runnable {

    private final String chore;

    @Override
    public void run() {
        System.out.printf("> start: %s in %s%n", chore, Thread.currentThread().getName());

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.printf("> complete: %s%n", chore);
    }

}
