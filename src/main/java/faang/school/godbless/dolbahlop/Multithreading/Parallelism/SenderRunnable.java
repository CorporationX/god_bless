package faang.school.godbless.dolbahlop.Multithreading.Parallelism;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SenderRunnable implements Runnable{
    private int startIndex;
    private int endIndex;
    @Override
    public void run() {
        for (int i = startIndex; i < endIndex; i++) {
            System.out.println("Massage " + i + " has been sent successfully");
        }
    }
}
