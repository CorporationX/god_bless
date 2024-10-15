package school.faang.work_in_microsoft_BJS2_37751;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SenderRunnable implements Runnable {
   private int startIndex;
   private int endIndex;

    @Override
    public void run() {
        for (int i = startIndex; i < endIndex; i++) {
            System.out.println("Message number: " + i + " sent");
        }
    }
}
