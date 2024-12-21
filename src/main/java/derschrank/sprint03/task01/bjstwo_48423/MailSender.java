package derschrank.sprint03.task01.bjstwo_48423;

import java.util.ArrayList;
import java.util.List;

public class MailSender implements MailSenderInterface {
    private static final int MAX_THREADS_DEFAULT = 5;
    private final int maxThreads;

    private final List<Mail> mails;
    private final int size;
    private final int sizeOfPaketForOneThread;

    public MailSender(List<Mail> mails) {
        this(mails, MAX_THREADS_DEFAULT);
    }

    public MailSender(List<Mail> mails, int maxThread) {
        this.mails = mails;
        this.maxThreads = maxThread;
        size = mails.size();
        sizeOfPaketForOneThread = calcSizeOfPaketForOneThread();
    }


    private int calcSizeOfPaketForOneThread() {
        return (int) Math.ceil(mails.size() / maxThreads);
    }

    public void send() {
        int pointer = 0;
        List<Thread> threads = new ArrayList<>();

        int oldPointer;
        SenderRunnable senderRunnable;
        Thread thread;
        for (int indexOfThread = 1; indexOfThread <= maxThreads && pointer <= size; indexOfThread++) {
            oldPointer = pointer;
            pointer += sizeOfPaketForOneThread;
            if (pointer > size || indexOfThread == maxThreads) {
                pointer = size;
            }

            senderRunnable = new SenderRunnable(mails, oldPointer, pointer);
            thread = new Thread(senderRunnable);
            thread.start();
            threads.add(thread);
        }

        waitForEndOfThreads(threads);
        System.out.println("\nAll mails were sent!!!");

    }

    private void waitForEndOfThreads(List<Thread> threads) {
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.out.println("waitForEndOfThreads: " + e);
            }
        }
    }
}
