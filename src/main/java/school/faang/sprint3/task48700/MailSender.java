package school.faang.sprint3.task48700;


import school.faang.sprint3.task48700.model.Mail;
import school.faang.sprint3.task48700.service.SenderRunnable;

import java.util.ArrayList;
import java.util.List;

public class MailSender {
    private static final int MAX_THREADS = 5;
    private static final int MAX_EMAILS = 1004;
    private static final List<Mail> emails = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {

        fillEmails();
        int batchSize = emails.size() / MAX_THREADS;
        Thread[] threads = new Thread[MAX_THREADS];

        int fromIndex;
        int toIndex;
        for (int i = 0; i < MAX_THREADS; i++) {
            fromIndex = i * batchSize;
            if (i == MAX_THREADS - 1) {
                toIndex = emails.size() - 1;
            } else {
                toIndex = ((i + 1) * batchSize - 1);
            }

            threads[i] = new Thread(new SenderRunnable(emails, fromIndex, toIndex));
            threads[i].start();
        }

        for (int i = 0; i < MAX_THREADS; i++) {
            threads[i].join();
            System.out.println("Thread " + i + " finished");
        }

        System.out.println("All emails are sent!");

    }

    private static void fillEmails() {
        for (int i = 0; i < MailSender.MAX_EMAILS; i++) {
            Mail mail = new Mail("a" + i + "@mail.ru",
                    "hr@microsoft.com",
                    "You are hired!" + i,
                    "Hello, you are hired! Microsoft >> " + i);
            emails.add(mail);
        }
    }
}
