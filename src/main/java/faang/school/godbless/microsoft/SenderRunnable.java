package faang.school.godbless.microsoft;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SenderRunnable implements Runnable {
    private int startIndex;
    private int endIndex;

    @Override
    public void run() {
        System.out.println("Send letter from " + startIndex + " to " + endIndex + ".");
    }
}
