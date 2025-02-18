package school.faang.they_were_very_nice_but_extremely_poor.BJS2_60770;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Chore implements Runnable {
    private final String title;

    @Override
    public void run() {
        System.out.println("Потоком " + Thread.currentThread().getName() + " выполняется: " + title);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
