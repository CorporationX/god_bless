package school.faang.bjs2_72912;

import lombok.Data;

@Data
public class SenderRunnable implements Runnable {

    private int startIndex;
    private int endIndex;

    public SenderRunnable(int startIndex, int endIndex) {
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    @Override
    public void run() {
        for (int i = startIndex; i  < endIndex; i++) {
            System.out.printf("Mail %d sent by %s\n", i, Thread.currentThread().getName());
        }
    }
}
