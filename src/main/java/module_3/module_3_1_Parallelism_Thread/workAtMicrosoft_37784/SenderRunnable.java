package module_3.module_3_1_Parallelism_Thread.workAtMicrosoft_37784;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SenderRunnable implements Runnable {
    private final int startIndex;
    private final int endIndex;

    @Override
    public void run() {
        for (int i = startIndex; i < endIndex; i++) {
            System.out.println("Письмо №" + (i + 1) + " отправлено.");
        }
    }
}
