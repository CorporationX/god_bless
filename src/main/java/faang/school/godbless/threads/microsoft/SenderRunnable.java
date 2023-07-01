package faang.school.godbless.threads.microsoft;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SenderRunnable implements Runnable {
    private int startIndex;
    private int endIndex;

    public void sendEmail() {
        for (int i = startIndex; i < endIndex; i++) {

        }
        System.out.println("[" + startIndex + " - " + endIndex + "]" + " сообщения успешно отправлены!");
    }

    @Override
    public void run() {
        sendEmail();
    }
}
