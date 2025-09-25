package school.faang.sprint3.chore;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Chore implements Runnable {

    private final String name;

    @Override
    public void run() {
        try {
            System.out.printf("%s выполняет задачу %s\n", Thread.currentThread().getName(), name);
            Thread.sleep(1000);
            System.out.printf("%s закончил задачу %s\n", Thread.currentThread().getName(), name);
        } catch (InterruptedException interruptedException) {
            System.out.printf("%s был прерван c ошибкой\n", Thread.currentThread().getName());
            Thread.currentThread().interrupt();
        }
    }
}
