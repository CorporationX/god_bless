package school.faang.sprint_3.task_48725;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Chore implements Runnable {
    private static final int TASK_EXECUTION_TIME_MS = 4000;
    private final String chore;

    @Override
    public void run() {
        try {
            System.out.printf("%s выполняет поток: %s%n",
                    Thread.currentThread().getName(), chore);
            Thread.sleep(TASK_EXECUTION_TIME_MS);

            System.out.printf("%s завершил поток: %s%n",
                    Thread.currentThread().getName(), chore);
        } catch (InterruptedException e) {
            System.err.printf("%s был прерван во время выполнения потока: %s%n",
                    Thread.currentThread().getName(), chore);
            Thread.currentThread().interrupt();
        }
    }
}
