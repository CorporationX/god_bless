package school.faang.bjs2_81182;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Chore implements Runnable {
    private final String chore;

    public void run() {
        try {
            System.out.printf("%s взял на себя задачу: %s", Thread.currentThread().getName(), chore);
            Thread.sleep(5000);
            System.out.printf("задача %s выполнена", chore);
        } catch (InterruptedException e) {
            System.out.printf("задача %s прервалась", chore);
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }

    }
}
