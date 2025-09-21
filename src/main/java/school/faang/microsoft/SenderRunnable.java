package school.faang.microsoft;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SenderRunnable implements Runnable {

    private int startIndex;
    private int endIndex;

    @Override
    public void run() {
        try {
            for (int i = startIndex; i <= endIndex; i++) {
                System.out.println(Thread.currentThread().getName() + " отправлено письмо #" + i);
            }
        } catch (Exception e) {
            Thread.currentThread().interrupt();
            System.out.println(Thread.currentThread().getName() + ": Меня прервали!");
        }
    }
}
