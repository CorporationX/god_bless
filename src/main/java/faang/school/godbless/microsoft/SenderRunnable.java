package faang.school.godbless.microsoft;

import java.util.List;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SenderRunnable implements Runnable {
    private int startIndex;
    private int endIndex;
    private int threadIndex;
    private List<String> messages;

    @Override
    public void run() {
        for (int i = startIndex; i <= endIndex; i++) {
            System.out.println("sent by " + threadIndex + ":" + messages.get(i));
        }
    }
}
