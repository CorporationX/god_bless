package school.faang.Weasley;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Chore implements Runnable {
    private final String title;

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " performs: " + title);
            Thread.sleep(1000);
            System.out.println(title + " completed!");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.printf("The task %s was interrupted", title);
        }
    }
}
