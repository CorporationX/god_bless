package school.faang.workformicrosoft;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SenderRunnable implements Runnable {
    private final int startIndex;
    private final int endIndex;

    @Override
    public void run() {
        for (int i = startIndex; i < endIndex; i++) {
            System.out.printf("Письмо отправлено: %d\n", i);
        }

        System.out.println("______________________");
        System.out.println("Все письма отправлены!");
    }
}
