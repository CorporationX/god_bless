package school.faang.sprint_3.task_48204;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

@AllArgsConstructor
public class SenderRunnable implements Runnable {
    private int startIndex;
    private int endIndex;

    @Override
    @SneakyThrows
    public void run() {
        for (int i = startIndex; i < endIndex; i++) {
            System.out.println("Письмо отправлено " + i);
        }
    }
}
