package faang.school.godbless.microsoft;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SenderRunnable implements Runnable {
    private int startIndex;
    private int endIndex;

    @Override
    public void run() {
        int current = endIndex - startIndex;
        for (int i = 1; i <= current; i++) {
            System.out.println(i + " Letters is sent");
        }
    }
}
