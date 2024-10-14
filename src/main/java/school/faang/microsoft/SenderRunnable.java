package school.faang.microsoft;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SenderRunnable implements Runnable {
    private final int startIndex;
    private final int endIndex;

    public void run() {
        for (int i = startIndex; i < endIndex; i++) {
            System.out.println("The letter has been sent: " + i);
        }
    }
}
