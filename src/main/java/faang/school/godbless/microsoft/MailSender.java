package faang.school.godbless.microsoft;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class MailSender {

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            int startIndex = 200 * i + 1;
            int endIndex = 200 * (i + 1);
            SenderRunnable senderRunnable = new SenderRunnable(startIndex, endIndex);
            Thread thread = new Thread(senderRunnable);
            thread.start();

            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("All letters have been successfully sent");
    }
}
