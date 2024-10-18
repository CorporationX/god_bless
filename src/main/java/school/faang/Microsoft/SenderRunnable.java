package school.faang.Microsoft;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class SenderRunnable implements Runnable{
    private int startIndex;
    private int endIndex;

    @Override
    public void run() {
        for (int i = startIndex + 1; i < endIndex + 1; i++) {
            System.out.println("Письмо №" + i + " отправлено.");
        }
    }
}
