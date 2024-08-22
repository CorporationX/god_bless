package they.were.very.nice.but.extremely.poor;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Chore implements Runnable {
    private final String chore;
    private final static int TASK_DELAY = 1000;

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.printf("Запущен поток %s с задачей %s\n", threadName, this.chore);

        try {
            Thread.sleep(TASK_DELAY);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.printf("Задача %s в потоке %s была выполнена\n", this.chore, threadName);
    }
}
