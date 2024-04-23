package faang.school.godbless.messagesthreads;

import java.util.List;


public class MailSender {
    public static void main(String[] args) throws InterruptedException {
        List<Thread> threads = List.of(new Thread(new SenderRunnable(1, 200)),
                new Thread(new SenderRunnable(200, 400)),
                new Thread(new SenderRunnable(400, 600)),
                new Thread(new SenderRunnable(600, 800)),
                new Thread(new SenderRunnable(800, 1000)));

        threads.forEach(Thread::start);
        for (Thread thread : threads) {
            thread.join();
        }
    }
}
