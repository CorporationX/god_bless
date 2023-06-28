package faang.school.godbless.microsoft;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SenderRunnable implements Runnable {
    private int startIndex;
    private int endIndex;

    @Override
    public void run() {
        for (startIndex = 0; startIndex < endIndex; startIndex++) {
            System.out.println("the latter send " + startIndex);
        }
    }
}
