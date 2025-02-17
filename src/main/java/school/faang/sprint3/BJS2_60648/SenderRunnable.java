package school.faang.sprint3.BJS2_60648;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class SenderRunnable implements Runnable {
    private final List<String> emails;

    @Override
    public void run() {
        emails.forEach(System.out::println);
    }
}
