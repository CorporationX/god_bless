package faang.school.godbless.youworkformicrosoft;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SenderRunnable implements Runnable {
    int startIndex;
    int endIndex;
    @Override
    public void run() {
        for (; startIndex <= endIndex; startIndex++) {
            System.out.println("Пиcьмо под номером " + startIndex + " было отправлено");
        }
    }

}
