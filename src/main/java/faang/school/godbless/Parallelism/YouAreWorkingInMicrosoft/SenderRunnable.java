package faang.school.godbless.Parallelism.YouAreWorkingInMicrosoft;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class SenderRunnable implements Runnable {
    private int startIndex;
    private int endIndex;

    @Override
    public void run() {
        for (int i = startIndex; i <= endIndex; i++) {
            sendEmail(i);
        }
    }

    private void sendEmail(int i) {
        System.out.println("Sending email number: " + i);
    }
}
