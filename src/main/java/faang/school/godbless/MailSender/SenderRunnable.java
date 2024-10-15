package faang.school.godbless.MailSender;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SenderRunnable implements Runnable {
    private int startIndex;
    private int endIndex;

    @Override
    public void run() {
        for (int i = startIndex; i < endIndex; i++) {
            System.out.println("Письмо отправлено " + i+" \t"+startIndex+"-"+endIndex);
        }
        System.out.println("\t\tЗавершение потока");
    }
}
