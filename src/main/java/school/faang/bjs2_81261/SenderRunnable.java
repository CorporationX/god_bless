package school.faang.bjs2_81261;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SenderRunnable implements Runnable {
    private final int startIndex;
    private final int endIndex;

    public void run() {
        for (int i = startIndex; i < endIndex; i++) {
            System.out.println("letter sent " + i);
        }
    }
}
