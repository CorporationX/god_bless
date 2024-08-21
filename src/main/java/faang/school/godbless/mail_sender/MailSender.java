package faang.school.godbless.mail_sender;

import java.util.List;

public class MailSender {

    public static void main(String[] args) {

        List<SenderRunnable> emailTasks = List.of(
                new SenderRunnable(1, 200),
                new SenderRunnable(201, 400),
                new SenderRunnable(401, 600),
                new SenderRunnable(601, 800),
                new SenderRunnable(801, 1000)
        );

        emailTasks.stream()
                .map(Thread::new)
                .peek(Thread::start)
                .forEach(t -> {
                    try {
                        t.join();
                    } catch(InterruptedException e) {
                        e.printStackTrace();
                    }
                });

        System.out.println("=====================================");
        System.out.println("All email tasks have been finished!!!");
    }
}
