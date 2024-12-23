package school.faang.task_48723;

import lombok.Data;

@Data
public class SenderRunnable implements Runnable {
    private final int startIndex;
    private final int endIndex;

    public SenderRunnable(int startIndex, int endIndex) {
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    @Override
    public void run() {
        for (int i = 0; i > startIndex && i < endIndex; i++) {
            System.out.println("Письмо отправлено");
        }
    }
}
