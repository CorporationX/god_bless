package faang.school.godbless.sendMassagesFromMicrosoft;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MailSender {

    public static void main(String[] args) {
        int totalEmails = 1000;
        int emailsPerThread = 200;
        int numberOfThreads = totalEmails / emailsPerThread;
        List<Thread> threads = IntStream.range(0, numberOfThreads)
                .mapToObj(i -> new Thread(new SenderRunnable(i * emailsPerThread, (i + 1) * emailsPerThread)))
                .toList();

        threads.forEach(Thread::start);
        threads.forEach((thread) -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        });
        System.out.println("All emails have been sent!");
    }
}
