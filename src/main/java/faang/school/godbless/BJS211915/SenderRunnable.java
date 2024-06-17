package faang.school.godbless.BJS211915;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SenderRunnable implements Runnable{
    private int startIndex;
    private int endIndex;

    @Override
    public void run() {
        for (int i = this.startIndex; i<this.endIndex+1; i++) {
            System.out.println(i + " message has successfully sent");
        }
    }
}
