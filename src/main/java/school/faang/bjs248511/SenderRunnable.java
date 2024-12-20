package school.faang.bjs248511;

import lombok.Setter;

public class SenderRunnable implements Runnable {
    private final int startIndex;
    private final int endIndex;
    @Setter
    private String threadName;

    public SenderRunnable(int startIndex, int endIndex) {
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    @Override
    public void run() {
        for (int i = startIndex; i < endIndex; i++) {
            System.out.println(threadName + " письмо отправлено: " + i);
        }
    }
}
