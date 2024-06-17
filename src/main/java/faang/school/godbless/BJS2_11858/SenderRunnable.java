package faang.school.godbless.BJS2_11858;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SenderRunnable implements Runnable{
    private int startIndex;
    private int endIndex;
    @Override
    public void run() {
        for (int i =startIndex; i<=endIndex ; i++) {
            System.out.println("The letter: " + i + " was sent successfully");
        }
    }
}
