package faang.school.godbless.sendMassagesFromMicrosoft;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SenderRunnable implements Runnable {
    private int startIndex;
    private int endIndex;
    private static int i = 0;
    @Override
    public void run() {
        System.out.println(i++);
    }
}
