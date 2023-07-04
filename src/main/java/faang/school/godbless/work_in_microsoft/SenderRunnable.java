package faang.school.godbless.work_in_microsoft;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SenderRunnable implements Runnable {

    int startIndex;
    int endIndex;

    @Override
    public void run() {
        for (int i = startIndex; i < endIndex; i++) {
            System.out.printf("Message #%d was sent!%n", i);
        }
    }
}
