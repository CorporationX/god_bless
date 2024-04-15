package faang.school.godbless.BJS2_5479;

import lombok.Data;

@Data
public class SenderRunnable implements Runnable {
    private int startIndex;
    private int endIndex;

    @Override
    public void run() {
        sendMessage(startIndex, endIndex);
    }

    public void sendMessage(int startIndex, int endIndex) {
        for (int i = startIndex; i <= endIndex; i++) {
            System.out.println("Отправлено сообщение " + i);
        }
    }
}