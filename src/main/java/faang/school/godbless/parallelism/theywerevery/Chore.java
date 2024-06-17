package faang.school.godbless.parallelism.theywerevery;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Chore implements Runnable {

    private String taskName;

    @Override
    public void run() {
        System.out.printf("Начало выполнения задани %s, в потоке %s\n",
                taskName, Thread.currentThread().getName());

        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.printf("Конец выполнения задани %s, в потоке %s\n",
                taskName, Thread.currentThread().getName());
    }
}
