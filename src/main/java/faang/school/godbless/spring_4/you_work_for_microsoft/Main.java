package faang.school.godbless.spring_4.you_work_for_microsoft;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Thread> threads = List.of(
                new Thread(new SenderRunnable(0, 200)),
                new Thread(new SenderRunnable(200, 400)),
                new Thread(new SenderRunnable(400, 600)),
                new Thread(new SenderRunnable(600, 800)),
                new Thread(new SenderRunnable(800, 1000))
        );

        MailSender sender = new MailSender();

        sender.sendEmails(threads);

    }
}
