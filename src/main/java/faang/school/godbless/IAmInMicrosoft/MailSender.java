package faang.school.godbless.IAmInMicrosoft;

import java.util.ArrayList;
import java.util.List;

public class MailSender {
    public static void main(String[] args) {
        List<Integer> mails = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            mails.add(i);
        }
        for (int i = 0; i < 5; i++) {
            SenderRunnable sender = new SenderRunnable(i*200, (i+1)*200-1);
            Thread thread = new Thread(sender);
            thread.start();
        }
    }
}
