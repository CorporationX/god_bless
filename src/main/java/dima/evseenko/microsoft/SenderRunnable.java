package dima.evseenko.microsoft;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SenderRunnable implements Runnable {
    private final int startIndex;
    private final int endIndex;

    @Override
    public void run() {
        for (int i = startIndex; i < endIndex; i++) {
            System.out.printf("Mail at index %s successfully sent%n", i);
        }
    }
}
