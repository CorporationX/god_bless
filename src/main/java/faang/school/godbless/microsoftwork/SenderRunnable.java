package faang.school.godbless.microsoftwork;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SenderRunnable implements Runnable {

    private int startIndex;
    private int endIndex;

    public void run() {
        for (int i = startIndex; i < endIndex; i++) {
            System.out.println(String.format("Mail %d is sent", i));
        }
    }
}
