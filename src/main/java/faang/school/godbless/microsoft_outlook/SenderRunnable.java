package faang.school.godbless.microsoft_outlook;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SenderRunnable implements Runnable {

    private int startIndex;
    private int endIndex;

    @Override
    public void run() {

        for (int i = startIndex; i <= endIndex; i++) {
            System.out.println("Message " + i + "  have been send");
        }
    }
}
