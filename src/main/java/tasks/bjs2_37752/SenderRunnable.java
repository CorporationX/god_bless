package tasks.bjs2_37752;

import lombok.Data;

import java.util.stream.IntStream;

@Data
public class SenderRunnable implements Runnable {
    private int startIndex;
    private int endIndex;
    private long threadId;

    public SenderRunnable(int startIndex, int endIndex) {
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    @Override
    public void run() {
        threadId = Thread.currentThread().getId();
        IntStream.range(startIndex, endIndex).forEach(this::emulateMessageSending);
    }

    private void emulateMessageSending(int mailNumber) {

        try {
            if (mailNumber == 1055) {
                throw new InterruptedException("Поток : " + threadId + ". Ошибка при отправке сообщения");
            }

            if (mailNumber == 1906) {
                Thread.sleep(5 * 60 * 1000);
            }

            System.out.println("Поток : " + threadId + ". Номер Сообщение : " + mailNumber + ".  : Успешно отправлено");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
