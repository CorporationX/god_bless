package faang.school.godbless.parallelism.microsoft;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SenderRunnable implements Runnable {

    private int startIndex;
    private int endIndex;

    @Override
    public void run() {
        for (int i = startIndex; i <= endIndex; i++) {
            System.out.printf("Mail №%d successfully sent\n", i);
        }
        System.out.println(startIndex + " - finished");
    }

}
