package school.faang.sprint_1.task_microsoftbjs2n48295;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@AllArgsConstructor
@Getter
@Slf4j
public class SenderRunnable implements Runnable {
    private int startIndex;
    private int endIndex;
    private List<String> emails;

    @Override
    public void run() {
        for (int i = startIndex; i <= endIndex; i++) {
            try {
                Thread.sleep(1);
                log.info(emails.get(i));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
