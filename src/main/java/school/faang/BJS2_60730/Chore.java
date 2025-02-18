package school.faang.BJS2_60730;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Chore implements Runnable {
    private String title;

    @Override
    public void run() {
        try {
            System.out.printf("%s выполняет задачу %s\n", Thread.currentThread().getName(), title);
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
