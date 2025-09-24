package school.faang.bjs2_91164_microsoft;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SenderRunnable implements Runnable {
    private int startIndex;
    private int endIndex;

    @Override
    public void run() {
        for (int i = startIndex; i <= endIndex; i++) {
            System.out.println("Письмо отправлено!");
        }
        System.out.println(
                Thread.currentThread().getName() +
                        ": Завершил отправку писем с номерами: " + startIndex + " - " + endIndex
        );
    }
}