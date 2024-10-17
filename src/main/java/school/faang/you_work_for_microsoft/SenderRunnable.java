package school.faang.you_work_for_microsoft;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SenderRunnable implements Runnable {
    private final int startIndex;
    private final int endIndex;

    @Override
    public void run() {
        for (int i = startIndex; i < endIndex + 1; i++) {
            System.out.println("Email has been sent successfully: " + i);
        }
    }
}