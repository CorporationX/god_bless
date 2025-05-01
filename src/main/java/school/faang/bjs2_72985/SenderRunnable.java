package school.faang.bjs2_72985;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class SenderRunnable implements Runnable {
    private final int startIndex;
    private final int endIndex;

    @Override
    public void run() {
        List<Mail> mails = MailService.getMails(startIndex, endIndex);

        for (Mail mail : mails) {
            System.out.printf("Сообщение '%s' отправлено. Поток: %s%n",
                    mail.subject(), Thread.currentThread().getName());
        }
    }
}
