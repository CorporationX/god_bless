package school.faang.sprint3task48692;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SenderRunnable implements Runnable {
    private int startIndex;
    private int endIndex;

    @Override
    public void run() {
        System.out.printf("Письмо отправлено с %s по %s \n", startIndex, endIndex);
    }
}