package work_for_Microsoft;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SenderRunnable implements Runnable {

    private int startIndex;
    private int endIndex;
    @Override
    public void run() {
        System.out.println("The letter was sent successfully");
    }
}