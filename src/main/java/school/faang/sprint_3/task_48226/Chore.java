package school.faang.sprint_3.task_48226;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Chore implements Runnable {
    private static final int PROCESS_DURATION = 1000;
    @NonNull
    private final String chore;

    @Override
    public void run() {
        System.out.printf("Starting chore: %s. By thread: %s\n",
                chore,
                Thread.currentThread().getName());

        try {
            Thread.sleep(PROCESS_DURATION);
        } catch (InterruptedException e) {
            System.out.printf("Thread %s was interrupted.\n", Thread.currentThread().getName());
        }

        System.out.println("Finished chore: " + chore);
    }
}
