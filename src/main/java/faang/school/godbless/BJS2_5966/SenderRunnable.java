package faang.school.godbless.BJS2_5966;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SenderRunnable implements Runnable {
    private int startIndex;
    private int endIndex;

    @Override
    public void run() {
        System.out.println("Emails from " + (startIndex + 1) + " to " + (endIndex + 1) + " have been delivered successfully.");
    }
}