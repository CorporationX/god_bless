package school.faang.sprint3.bjs248689;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SenderRunnable implements Runnable {
    private final int startIndex;
    private final int endIndex;

    @Override
    public void run() {
        for (int i = startIndex; i < endIndex; i++) {
            try {
                System.out.println(i + "-e письмо отправлено.");
            } catch (Exception e) {
                System.err.println("Ошибка при отправке " + i + "-го письма: " + e.getMessage());
            }
        }
    }
}