package school.faang.bjs2_89553;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SenderRunnable implements Runnable {
    private final int startIndex;
    private final int endIndex;

    public void run() {
        for (int i = startIndex; i <= endIndex; i++) {
            System.out.println("Письмо " + startIndex + " отправлено");
        }
    }
}
