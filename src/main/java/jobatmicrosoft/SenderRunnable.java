package jobatmicrosoft;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SenderRunnable implements Runnable {

    private int startIndex;
    private int endIndex;

    @Override
    public void run() {
        for (int i = startIndex; i < endIndex; i++) {
            System.out.println(String.format("Mail: %s. Thread: %s.", i, Thread.currentThread().getName()));
        }
    }
}