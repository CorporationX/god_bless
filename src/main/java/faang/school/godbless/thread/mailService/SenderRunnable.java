package faang.school.godbless.thread.mailService;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SenderRunnable implements Runnable {
    int startIndex;
    int endIndex;

    @Override
    public void run() {
        for (int i = startIndex; i < endIndex; i++) {
            System.out.printf("Сообщение №%d отправлено\n", i);
        }

        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + " закончил работу");
    }
}
