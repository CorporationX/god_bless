package school.faang.task60583.service;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SenderRunnable implements Runnable {

    private final int startIndex;
    private final int endIndex;


    @Override
    public void run() {
        for (int i = startIndex; i < endIndex; i++) {
            System.out.printf("Письмо %d отправлено%n", i);
        }
    }
}
