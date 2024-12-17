package school.faang.task_48089;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SenderRunnable implements Runnable {
    private final int startIndex;
    private final int endIndex;

    @Override
    public void run() {
        for (int i = startIndex; i < endIndex; i++) {
            System.out.printf("%nПисьмо %d отправлено в потоке %s", i, Thread.currentThread().getName());
        }
    }
}
