package school.faang.Microsoft;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class SenderRunnable implements Runnable{
    int startIndex;
    int endIndex;

    @Override
    public void run() {
        for (int i = startIndex; i < endIndex; i++) {
            System.out.println("Письмо №" + i + " отправлено.");
        }
    }
}
