package school.faang.microsoft;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SenderRunnable implements Runnable {

    private int startIndex;
    private int endIndex;

    @Override
    public void run() {
        for (int i = startIndex; i <= endIndex; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.printf("Email #%d was sent%n", i);
        }
    }
}
