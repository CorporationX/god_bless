package school.faang.ThetWereVeryNice;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Chore implements Runnable{
    private final String chore;
    @Override
    public void run() {
        try {
            System.out.println("Поток " + Thread.currentThread().getName() + ": выполняет задачу " + chore);
            Thread.sleep(3000);
            System.out.println("Поток " + Thread.currentThread().getName() + ": ВЫПОЛНЛ ЗАДАЧУ");
        } catch (InterruptedException ignored) {
            System.out.println("Поток " + Thread.currentThread().getName() + " прерван");
            Thread.currentThread().interrupt();
        }
    }
}
