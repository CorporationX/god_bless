package faang.school.godbless.microsoft;

import java.util.List;
import java.util.stream.IntStream;

public class MailSender {
    public static void main(String[] args) {
        sendMail(IntStream.range(0, 1001).boxed().map(String::valueOf).toList(), 5);
    }

    public static void sendMail(List<String> list, int threadsNumber) {
        int messageQueueSize = list.size();
        int batchSize = messageQueueSize / threadsNumber;
        for (int i = 0; i < messageQueueSize/batchSize; i++) {
            Thread thread = new Thread(new SenderRunnable(i * batchSize, (i+1) * batchSize, list));
            thread.setName(String.valueOf(i));
            thread.start();
        }
    }
}
