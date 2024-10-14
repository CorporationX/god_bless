package you_work_for_microsoft;

import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;

public class MailSender {
    private static final int COUNT_OF_THREADS = 5;
    private static final int COUNT_OF_MAILS = 1000;

    @SneakyThrows
    public static void main(String[] args) throws InterruptedException {
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < COUNT_OF_THREADS; i++) {
            threads.add(new Thread(new SenderRunnable(COUNT_OF_MAILS / COUNT_OF_THREADS * i,
                    COUNT_OF_MAILS / COUNT_OF_THREADS * (i + 1))));
        }

        threads.forEach(Thread::start);

        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println("Все письма отправлены");
    }
}
