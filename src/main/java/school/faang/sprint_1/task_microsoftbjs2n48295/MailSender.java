package school.faang.sprint_1.task_microsoftbjs2n48295;

import java.util.ArrayList;
import java.util.List;

public class MailSender {
    private static final int EMAIL_NUMBER = 1000;
    private static final int BATCH_SIZE = 200;

    public static void main(String[] args) {

        List<String> emails = new ArrayList<>();
        for (int i = 1; i <= EMAIL_NUMBER; i++) {
            if (i == 2) {
                emails.add(null);
            } else {
                emails.add("Text email " + i);
            }
        }

        for (int i = 0; i < EMAIL_NUMBER; i++) {
            if (i % BATCH_SIZE == 0) {
                new Thread(new SenderRunnable(i, (i / BATCH_SIZE + 1) * BATCH_SIZE - 1, emails)).start();
            }
        }
    }
}
