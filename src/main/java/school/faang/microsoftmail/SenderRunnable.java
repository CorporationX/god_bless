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
        while (endIndex > startIndex) {
            System.out.println("Letter with index " + startIndex + " was sent");
            startIndex++;
        }
    }
}
