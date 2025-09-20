package school.faang.bjs2_91093;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class SenderRunnable implements Runnable {
    private final int startIndex;
    private final int endIndex;
    boolean partOfMailsSent = false;

    @Override
    public void run() {
        for (int i = startIndex; i < endIndex; i++) {
            System.out.printf("Отправлено письмо #%d\n", i);
        }
        partOfMailsSent = true;
    }
}
