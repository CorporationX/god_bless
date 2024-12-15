package school.faang.sprint3.bjs_48265;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SenderRunnable implements Runnable {
    private final int startIndex;
    private final int endIndex;

    @Override
    public void run() {
        for (int i = startIndex; i < endIndex; i++) {
            System.out.println("Письмо отправлено: " + i);
        }
    }
}
