package work.in.microsoft;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SenderRunnable implements Runnable{
    private final int startIndex;
    private final int endIndex;

    @Override
    public void run() {
        System.out.printf("Отправлены письма с %d по %d\n", this.startIndex, this.endIndex);
    }
}
