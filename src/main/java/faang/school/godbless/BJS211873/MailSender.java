package faang.school.godbless.BJS211873;

import lombok.SneakyThrows;

import java.util.List;
import java.util.stream.Stream;

public class MailSender {

    private static final int BATCH_SIZE = 200;

    @SneakyThrows
    public static void main(String[] args) {
        List<Thread> senderRunnables = Stream.iterate(new SenderRunnable(0, BATCH_SIZE), n -> new SenderRunnable(n.getEndIndex() + 1, n.getEndIndex() + BATCH_SIZE))
                .limit(5)
                .map(Thread::new)
                .peek(Thread::start)
                .toList();
        senderRunnables.forEach(Thread::join);

        System.out.println("finish");
    }
}
