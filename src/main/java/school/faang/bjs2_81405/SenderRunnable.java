package school.faang.bjs2_81405;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SenderRunnable implements Runnable {
    private static final int SLEEP_NUMBER = 5;
    private int startIndex;
    private int endIndex;
    private int threadId;

    @Override
    public void run() {
        for (int i = startIndex; i <= endIndex; i++) {
            System.out.printf("Письмо %d  было отправлено потоком: %d\n", i, threadId);
            try {
                Thread.sleep(SLEEP_NUMBER);
            } catch (InterruptedException e) {
                throw new IllegalStateException("Поток был прерван, во время ожидания(sleep)", e);
            }
        }
    }
}
