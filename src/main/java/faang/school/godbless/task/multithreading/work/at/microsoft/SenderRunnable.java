package faang.school.godbless.task.multithreading.work.at.microsoft;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SenderRunnable implements Runnable {
    private final int starterIndex;
    private final int endIndex;

    @Override
    public void run() {
        for (int i = starterIndex; i <= endIndex; i++) {
            System.out.println("Mail #%s send".formatted(i));
        }
    }
}
