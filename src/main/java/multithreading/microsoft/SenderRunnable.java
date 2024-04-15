package multithreading.microsoft;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
public class SenderRunnable implements Runnable {
    private int startIndex;
    private int endIndex;

    @Override
    public void run() {
        for (int i = this.startIndex; i <= this.endIndex; i++) {
            System.out.println(String.format("Message %d send", i));
        }
    }
}
