package faang.school.godbless.parallelism.microsoft;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SenderRunnable implements Runnable {

    private int startIndex;
    private int endIndexExclusive;

    @Override
    public void run() {
        for (int i = startIndex; i < endIndexExclusive; i++) {
            System.out.println("Письмо " + i + " отправлено");
        }
    }
}
