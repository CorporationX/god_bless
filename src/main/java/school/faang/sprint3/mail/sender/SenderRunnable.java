package school.faang.sprint3.mail.sender;

import lombok.RequiredArgsConstructor;

import java.util.stream.IntStream;

@RequiredArgsConstructor
public class SenderRunnable implements Runnable {

    private final Integer startIndex;
    private final Integer endIndex;

    @Override
    public void run() {
        IntStream.range(startIndex, endIndex)
                .forEach(messageNumber -> System.out.printf("%s письмо отправлено\n", messageNumber));
    }
}
