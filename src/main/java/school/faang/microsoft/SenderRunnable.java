package school.faang.microsoft;

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
        for (int i = startIndex; i <= endIndex; i++) {
            System.out.println(String.format("Письмо с индексом %d отправлено", i));
            Counter.count.incrementAndGet();
        }
    }
}
