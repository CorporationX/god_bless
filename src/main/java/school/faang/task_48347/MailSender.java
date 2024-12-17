package school.faang.task_48347;

import java.util.ArrayList;
import java.util.List;

public class MailSender {
    private static final List<Thread> emailSenderThreads = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        int batch = 200;

        for (var i = 0; i < 1000; i += batch) {
            Thread emailSenderThread = new Thread(new SenderRunnable(i, i + batch));
            emailSenderThreads.add(emailSenderThread);
            emailSenderThread.start();
        }

        for (var emailSenderThread : emailSenderThreads) {
            emailSenderThread.join();
        }

        System.out.println("Все письма отправлены");
    }
}
