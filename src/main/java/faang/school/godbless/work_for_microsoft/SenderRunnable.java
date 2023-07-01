package faang.school.godbless.work_for_microsoft;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SenderRunnable implements Runnable {
    private int startIndex;
    private int endIndex;
    @Override
    public void run() {
        System.out.println("Your letters has been delivered!");
    }
}
