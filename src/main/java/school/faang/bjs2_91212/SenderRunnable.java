package school.faang.bjs2_91212;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SenderRunnable implements Runnable {
    private final int startIndex;
    private final int endIndex;

    @Override
    public void run() {
        for (int i = startIndex; i <= endIndex; i++) {
            System.out.println(Thread.currentThread().getName() +
                    " обрабатывает письмо #" + i);
        }
    }
}