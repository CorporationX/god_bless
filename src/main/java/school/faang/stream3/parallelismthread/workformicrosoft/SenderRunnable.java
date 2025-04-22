package school.faang.stream3.parallelismthread.workformicrosoft;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class SenderRunnable implements Runnable {
    private final List<Email> emailBucket;

    @Override
    public void run() {
        for (Email email : emailBucket) {
            System.out.println("Message has been sent");
        }
    }
}
