package school.faang.stream3.youareinmicrosoft;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SenderRunnable implements Runnable {
    private final int startIndex;
    private final int endIndex;

    @Override
    public void run() {
        System.out.printf("thread started work from %d\n", startIndex);
        for (int i = startIndex; i <= endIndex; i++) {
            System.out.printf("Sending %s\n", MailSender.emails.get(i));
        }
        System.out.printf("thread ended work at %d\n", endIndex);

    }
}
