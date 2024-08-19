package faang.school.godbless.microsoft;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SenderRunnable implements Runnable {

    private final int startIndex;
    private final int finalIndex;

    @Override
    public void run() {
        for (int i = startIndex; i <= finalIndex; i++) {
            System.out.println("Mail " + i + " has been processed");
        }
    }
}
