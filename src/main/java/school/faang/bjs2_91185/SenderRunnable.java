package school.faang.bjs2_91185;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SenderRunnable implements Runnable {
    private final int startIndex;
    private final int endIndex;

    @Override
    public void run() {
        for (int i = startIndex; i <= endIndex; i++) {
            System.out.printf("Письмо %s отправлено потоком %s%n",
                    i, Thread.currentThread().getName());
        }
    }
}