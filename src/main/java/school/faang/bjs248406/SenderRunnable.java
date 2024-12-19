package school.faang.bjs248406;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SenderRunnable implements Runnable {
    private int startIndex;
    private int finishIndex;

    @Override
    public void run() {
        System.out.println("Letter is " + startIndex +  " to " + finishIndex + " is sent successfully!");
    }
}
