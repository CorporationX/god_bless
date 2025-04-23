package school.faang.they_were_very_nice_but_extremely_poor;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Chore implements Runnable {
    private final String chore;

    @Override
    public void run() {
        System.out.println("Поток " + Thread.currentThread().getName() + " начал выполнение задачи: " + chore);

        try {
            int duration = (int) (Math.random() * 2000) + 1000;
            Thread.sleep(duration);

            System.out.println("Поток " + Thread.currentThread().getName() +
                    " завершил задачу: " + chore +
                    " за " + duration + " мс");
        } catch (InterruptedException e) {
            System.out.println("Поток " + Thread.currentThread().getName() +
                    " был прерван во время выполнения задачи: " + chore);
            Thread.currentThread().interrupt();
        }
    }
}
