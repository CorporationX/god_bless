package faang.school.godbless.microsoft;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import lombok.SneakyThrows;

public class MailSender {
    @SneakyThrows
    public static void main(String[] args) {
        List<String> messages = IntStream.range(0, 1000).mapToObj(i -> "message" + i).toList();
        List<Thread> threads = IntStream.range(0, 5).mapToObj(i -> new Thread(new SenderRunnable(i * 200,
                i * 200 + 199, i, messages))).toList();

        threads.forEach(Thread::start);
        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        });
        System.out.println("all messages processed");
    }
}
