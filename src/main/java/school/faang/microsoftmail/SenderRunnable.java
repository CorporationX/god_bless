package school.faang.microsoftmail;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SenderRunnable implements Runnable {

    private int startIndex;
    private int endIndex;

    @Override
    public void run() {
        for (int i = 0; i < endIndex - startIndex; i++) {
            System.out.println("Letter with index " + (startIndex + i) + " was sent");
        }
    }
}
