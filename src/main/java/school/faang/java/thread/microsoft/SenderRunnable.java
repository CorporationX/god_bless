package school.faang.java.thread.microsoft;

import lombok.Data;

@Data
public class SenderRunnable implements Runnable {
    private final int startIndex;
    private final int endIndex;

    @Override
    public void run() {
        for (int i = startIndex; i <= endIndex; i++) {
            System.out.printf("\nSending email ... : %s", MailSender.listEmails.get(i));
        }
    }
}