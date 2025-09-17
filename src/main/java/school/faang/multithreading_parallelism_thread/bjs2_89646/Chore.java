package school.faang.multithreading_parallelism_thread.bjs2_89646;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Chore implements Runnable {
    private final String chore;

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " выполняет задачу: " + chore);
            Thread.sleep(1000);
            System.out.printf("Задача '%s' выполнена!\n", chore);
        } catch (InterruptedException e) {
            System.out.printf("Задача '%s' была прервана.\n", chore);
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }
}
