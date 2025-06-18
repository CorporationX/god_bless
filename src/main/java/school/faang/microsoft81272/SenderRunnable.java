package school.faang.microsoft81272;

import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
public class SenderRunnable implements Runnable {
    @Getter
    private static int count = 0;
    private int startIndex;
    private int endIndex;

    @Override
    public void run() {

        for (int i = startIndex; i < endIndex; i++) {
            String nunThread = Thread.currentThread().getName();
            System.out.printf("Письмо %s отправлено из потока %s %n", i, nunThread);
            count++;
        }
    }
}
