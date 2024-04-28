package faang.school.godbless.sprint3.BJS2_6306;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SenderRunnable implements Runnable {
    private final int startIndex;
    private final int endIndex;

    @Override
    public void run() {
        for (int i = startIndex; i <= endIndex; i++) {
            sendMail(i);
        }
    }

    private void sendMail(int mailId) {
        System.out.println("Mail " + mailId + " has been sent.");
    }
}