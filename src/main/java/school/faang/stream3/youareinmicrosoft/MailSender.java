package school.faang.stream3.youareinmicrosoft;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class MailSender {
    public static List<String> emails = new ArrayList<>();
    public static final int DELAYED_EMAILS = 998;
    public static final int THREAD_COUNT = 5;
    public static final int BATCH_SIZE = DELAYED_EMAILS / THREAD_COUNT + 1;

    public static void main(String[] args) {

        for (int i = 0; i < DELAYED_EMAILS; i++) {
            emails.add("email #" + i);
        }
        List<Thread> threadList = new ArrayList<>();
        for (int i = 0; i < THREAD_COUNT; i++) {
            int startIndex = i * BATCH_SIZE;
            int endIndex = Math.min((i + 1) * BATCH_SIZE - 1, DELAYED_EMAILS - 1);
            threadList.add(new Thread(
                    new SenderRunnable(startIndex, endIndex)
            ));
        }
        threadList.forEach(Thread::start);

        try {
            for (Thread thread : threadList) {
                thread.join();
            }
        } catch (InterruptedException e) {
            log.error("Thread interrupted", e);
        }
        System.out.println("Main thread: sending done");
    }
}
