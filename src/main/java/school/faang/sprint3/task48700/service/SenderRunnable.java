package school.faang.sprint3.task48700.service;

import school.faang.sprint3.task48700.model.Mail;

import java.util.List;

public class SenderRunnable implements Runnable {

    private static final int LOAD_IMITATION = 100;
    private final int startIndex;
    private final int endIndex;
    private final List<Mail> mails;

    public SenderRunnable(List<Mail> mails, int startIndex, int endIndex) {
        this.startIndex = startIndex;
        this.endIndex = endIndex;
        this.mails = mails;
    }

    @Override
    public void run() {

        for (int i = startIndex; i <= endIndex; i++) {
            System.out.println("Mail " + mails.get(i) + " sent to address...");
            try {
                Thread.sleep(LOAD_IMITATION);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
