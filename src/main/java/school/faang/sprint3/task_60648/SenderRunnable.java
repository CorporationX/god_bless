package school.faang.sprint3.task_60648;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class SenderRunnable implements Runnable {
    public static int emailNumber = 1;
    private final int threadNumber;
    private final List<String> emails;

    @Override
    public void run() {
        emails.forEach(email -> System.out.printf("%d) thread%s - %s\n", emailNumber++, threadNumber, email));
    }
}
