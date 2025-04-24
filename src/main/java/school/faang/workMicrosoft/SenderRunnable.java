package school.faang.workMicrosoft;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SenderRunnable implements Runnable {
    private int startIndex;
    private int endIndex;

    @Override
    public void run() {
        for (int i = startIndex; i < endIndex; i++) {
            System.out.printf("[Поток %s] Письмо №%d отправлено%n", Thread.currentThread().getName(), i);
        }
    }
}