package school.faang.sprint_3.task_48725;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Chore implements Runnable {
    private final String chore;

    @Override
    public void run() {
        try {
            System.out.printf("%s выполняет поток: %s%n",
                    Thread.currentThread().getName(), chore);
            Thread.sleep(4000);

            System.out.printf("%s завершил поток: %s%n",
                    Thread.currentThread().getName(), chore);
        } catch (InterruptedException e) {
            System.err.printf("%s был прерван во время выполнения потока: %s%n",
                    Thread.currentThread().getName(), chore);
        }
    }
}
