package school.faang.multithreading.jobInMicrosoft;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SenderRunnable implements Runnable {
    private Integer startIndex;
    private Integer endIndex;

    @Override
    public void run() {
        for (int i = startIndex; i <= endIndex; i++) {
            System.out.printf("Письмо #%s отправлено%n", i);
        }
    }
}
