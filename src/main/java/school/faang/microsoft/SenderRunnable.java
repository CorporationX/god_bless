package school.faang.microsoft;

import lombok.AllArgsConstructor;

import java.util.concurrent.TimeUnit;

@AllArgsConstructor
public class SenderRunnable implements Runnable {

    private int startIndex;
    private int endIndex;

    @Override
    public void run() {
        try {
            System.out.println("Письмо отправлено");
        } catch (Exception e) {
            Thread.currentThread().interrupt();
            System.out.println("Меня прервали!");
        }
    }

    public void join() {
    }
}
