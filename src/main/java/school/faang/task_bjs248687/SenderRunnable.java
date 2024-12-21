package school.faang.task_bjs248687;

import lombok.Data;

@Data
public class SenderRunnable implements Runnable {
    private final int startIndex;
    private final int endIndex;

    public void run() {
        for (int i = startIndex; i < endIndex; i++) {
            System.out.printf("Письмо %d отправлено\n", i);
        }
    }
}
