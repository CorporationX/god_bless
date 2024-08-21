package work.in.microsoft;

import lombok.AllArgsConstructor;

import java.util.Random;

@AllArgsConstructor
public class SenderRunnable implements Runnable{
    private final int startIndex;
    private final int endIndex;
    private static final int MAX_DELAY_TIME = 500;

    @Override
    public void run() {
        for (int i = this.startIndex; i <= this.endIndex; i++) {
            try {
                Thread.sleep(new Random().nextInt(MAX_DELAY_TIME));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.printf("Отправлено %d письмо\n", i);
        }
    }
}
