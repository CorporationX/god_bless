package school.faang.bjs272715;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SenderRunnable implements Runnable {
    private int startIndex;
    private int endIndex;

    @Override
    public void run() {
        for (int i = startIndex; i < endIndex; i++) {
            // Send message logic
        }

        System.out.printf("Messages from %d to %d sent.\n", startIndex, endIndex - 1);
    }
}
