package school.faang.sprint.third.microsoft;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class SenderRunnable implements Runnable {
    private final int startIndex;
    private final int endIndex;

    @Override
    public void run() {
        validateIndexes();
        for (int i = startIndex; i <= endIndex; i++) {
            System.out.println("Current thread: " + Thread.currentThread().getId() + ". Sending " + i + " email");
        }
    }

    private void validateIndexes() {
        if (startIndex < 0 || endIndex < 0) {
            throw new IllegalArgumentException("Indexes cannot be negative");
        }
        if (startIndex > endIndex) {
            throw new IllegalArgumentException("End index cannot be less than start index");
        }
    }
}
