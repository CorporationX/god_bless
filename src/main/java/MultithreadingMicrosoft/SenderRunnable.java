package MultithreadingMicrosoft;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class SenderRunnable implements Runnable {
    private int startIndex;
    private int endIndex;

    @Override
    public void run() {
        for (int i = startIndex + 1; i < endIndex + 1; i++) {
            System.out.println("Message sent! " + i);
        }
    }
}
