package school.faang.bjs2_89732;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Chore implements Runnable {
    private final String chore;

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " выполняет задачу " + chore);
            Thread.sleep(5000);
            System.out.println(chore + " выполнена!");
        } catch (InterruptedException e) {
            System.out.println("Задача " + chore + " была прервана.");
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }
}
