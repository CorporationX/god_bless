package school.faang.bjs2_89592;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@Getter
public class Chore implements Runnable {
    private static final long TIME_PERFORM_TASK = 1_000;
    private String chore;

    @Override
    public void run() {
        try {
            System.out.printf("%s performs the task %s\n", Thread.currentThread().getName(), chore);
            Thread.sleep(TIME_PERFORM_TASK);
            System.out.printf("%s - task completed\n", chore);
        } catch (InterruptedException e) {
            System.out.printf("task %s interrupted\n", chore);
            Thread.currentThread().interrupt();
        }
    }
}
