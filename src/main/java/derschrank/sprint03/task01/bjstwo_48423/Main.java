package derschrank.sprint03.task01.bjstwo_48423;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Mail> mails = new ArrayList<>();

        for (int i = 0; i < 1000; i++) {
            mails.add(new Mail(i, "Mail to ABC"));
        }
        MailSender sender = new MailSender(mails);
        sender.send();
    }
}
