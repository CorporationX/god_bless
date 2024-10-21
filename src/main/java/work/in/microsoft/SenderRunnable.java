package work.in.microsoft;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SenderRunnable implements Runnable {
    private final int startIndex;
    private final int endIndex;

    @Override
    public void run() {
        try {
            for (int i = startIndex; i < endIndex; i++) {
                System.out.println("Mail sent: " + i);
            }
        } catch (Exception e) {
            System.err.println("Exception " + e + ", startIndex: " + startIndex + ", endIndex: " + endIndex);
            e.printStackTrace();
        }

    }
}
