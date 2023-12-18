package faang.school.godbless.work_microsoft;

import lombok.AllArgsConstructor;
import lombok.Data;

public class MailSender {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            int start = i * 200;
            int end = start + 200;
            SenderRunnnable senderRunnnable = new SenderRunnnable(start, end);
            Thread thread = new Thread(senderRunnnable);
            thread.start();
            thread.join();
        }
    }
}

@Data
@AllArgsConstructor
class SenderRunnnable implements Runnable {
    private int startIndex;
    private int endIndex;

    @Override
    public void run() {
        for (int i = startIndex; i < endIndex; i++) {
            System.out.println("Message sent");
        }
    }
}