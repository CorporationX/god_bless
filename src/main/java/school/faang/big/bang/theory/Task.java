package school.faang.big.bang.theory;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Getter
@AllArgsConstructor
@Slf4j
public class Task implements Runnable {
    private String executorName;
    private String taskName;

    @Override
    public void run() {
        System.out.println(executorName + " приступил к задаче " + taskName);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            log.error(e.getMessage());
            log.error(Arrays.toString(e.getStackTrace()));
        }
        System.out.println("Задача " + taskName + " завершена!");
    }
}
