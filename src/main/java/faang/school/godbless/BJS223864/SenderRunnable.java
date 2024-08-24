package faang.school.godbless.BJS223864;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SenderRunnable implements Runnable {
    private Integer startIndex;
    private Integer endIndex;
    @Override
    public void run() {
        for (int i = startIndex; i < endIndex; i++) {
            System.out.println("Sending message: #" + i);
        }
    }
}
