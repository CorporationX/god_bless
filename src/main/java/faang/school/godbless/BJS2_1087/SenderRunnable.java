package faang.school.godbless.BJS2_1087;

import lombok.Data;

@Data
public class SenderRunnable implements Runnable{
    private int startIndex;
    private int endIndex;

    public SenderRunnable(int startIndex, int endIndex) {
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    @Override
    public void run() {
        for (int i = startIndex; i < endIndex; i++) {
            System.out.println("Mail " + i + " was successfully sent");
        }
    }
}
