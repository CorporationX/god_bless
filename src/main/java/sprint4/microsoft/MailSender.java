package sprint4.microsoft;

import java.util.ArrayList;
import java.util.List;

public class MailSender {
    private static final List<String> MAILS = new ArrayList<>();

    static {
        fillList();
    }
    private static final List<Thread> THREAD_LIST = List.of(
            new Thread(new SenderRunnable(MAILS.subList(0, 200))),
            new Thread(new SenderRunnable(MAILS.subList(200, 400))),
            new Thread(new SenderRunnable(MAILS.subList(400, 600))),
            new Thread(new SenderRunnable(MAILS.subList(600, 800))),
            new Thread(new SenderRunnable(MAILS.subList(800, 1000)))
    );

    public static void main(String[] args) {

        for (Thread thread : THREAD_LIST) {
            thread.start();
        }
        joinInWorkThreads();
        System.out.println("All messages have been sent");
    }

    private static void joinInWorkThreads() {
        for (Thread thread : THREAD_LIST) {
            if (!thread.isInterrupted()) {
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    System.out.printf("the operation of thread \"%s\" has been suspended\n", thread.getName());
                }
            }
        }
    }

    private static void fillList() {
        for (int i = 0; i < 1000; i++) {
            MAILS.add("Mail ¹" + i);
        }
    }
}