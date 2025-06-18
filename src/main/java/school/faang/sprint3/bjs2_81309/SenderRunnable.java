package school.faang.sprint3.bjs2_81309;

import java.util.List;

public class SenderRunnable implements Runnable {
    private final List<Integer> mails;

    SenderRunnable(List<Integer> mails) {
        this.mails = mails;
    }

    @Override
    public void run() {
        mails.forEach(mail -> {
            System.out.println("Сообщение " + mail);
        });
    }
}
