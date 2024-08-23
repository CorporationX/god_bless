package faang.school.godbless.sendMassagesFromMicrosoft;

import java.util.stream.IntStream;

public class MailSender {
    public static void main(String[] args) {
        IntStream.range(0,5)
                .mapToObj(i-> new Thread(new SenderRunnable(0,200)))
                .forEach(Thread::start);
    }
}
