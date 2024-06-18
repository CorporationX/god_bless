package faang.school.godbless.thread1;

import java.util.ArrayList;
import java.util.List;

public class MailSender {

    private static final String ALL_MAIL_SENT = "Все сообщения отправлены";
    private static final String ERROR = "Ошибка отправки сообщения:";
    private static final int MAX_THREADS = 5;
    private static final int MESSAGES_IN_ONE_THREAD = 200;
    private static final int STEP = 199;

    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < MAX_THREADS; i++) {
            int startIndex = i * MESSAGES_IN_ONE_THREAD + 1;
            int endIndex = startIndex + STEP;
            Thread thread = new Thread(new SenderRunnable(startIndex, endIndex));
            threads.add(thread);
            thread.start();
        }
        threads.forEach(MailSender::threadJoin);
        System.out.println(ALL_MAIL_SENT);
    }

    private static void threadJoin(Thread thread) {
        try {
            thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(ERROR + e.getMessage());
        }
    }
}
