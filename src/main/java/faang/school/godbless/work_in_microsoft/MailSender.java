package faang.school.godbless.work_in_microsoft;

import java.util.stream.IntStream;

public class MailSender {
    public static void main(String[] args) {
        int totalMessages = 1000;
        int messagesPerThread = 200;
        IntStream.range(0, 5)
                .mapToObj(i -> new SenderRunnable(i * messagesPerThread, Math.min((i + 1) * messagesPerThread, totalMessages)))
                .map(Thread::new)
                .forEach(Thread::start);
    }
}
