package school.faang.bjs280861;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SenderRunnable implements Runnable {
    private int startIndex;
    private int endIndex;

    @Override
    public void run() {
        while (startIndex < endIndex) {
            startIndex += 1;
            System.out.println(startIndex + " Письмо отправлено надо: " + endIndex);
        }
    }
}
