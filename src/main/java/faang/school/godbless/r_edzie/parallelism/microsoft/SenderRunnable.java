package faang.school.godbless.r_edzie.parallelism.microsoft;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SenderRunnable implements Runnable {
    private int startIndex;
    private int endIndex;

    @Override
    public void run() {
        System.out.printf("Письмо c %s отправлено до %s%n", startIndex, endIndex);
    }
}
