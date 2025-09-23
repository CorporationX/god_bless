package school.faang.m1.thread.mail;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class SenderRunnable implements Runnable {
    int startIndex;
    int endIndex;

    @Override
    public void run() {
        for (int i = startIndex; i < endIndex; i++) {
            System.out.printf("[%s] Письмо %d отправлено%n", Thread.currentThread().getName(), i);
        }
    }
}
