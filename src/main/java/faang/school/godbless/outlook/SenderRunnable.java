package faang.school.godbless.outlook;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SenderRunnable implements Runnable {
    private int startIndex;
    private final int endIndex;

    @Override
    public void run() {
        while(startIndex <= endIndex) {
            System.out.println("Email " + startIndex + " were sent successfully!");
            startIndex++;
        }
    }
}



