package multithreading.microsoft;

import java.util.List;

public class MailSender {
    public static void main(String[] args) throws InterruptedException {
        List<Thread> threads = List.of(new Thread(new SenderRunnable(1, 199)),
                new Thread(new SenderRunnable(200, 399)),
                new Thread(new SenderRunnable(400, 599)),
                new Thread(new SenderRunnable(600, 799)),
                new Thread(new SenderRunnable(800, 1000)));

        threads.forEach(Thread::start);
        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });


        System.out.println("All message sent");

    }
}
