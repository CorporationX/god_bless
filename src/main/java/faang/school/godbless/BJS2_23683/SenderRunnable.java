package faang.school.godbless.BJS2_23683;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SenderRunnable implements Runnable {
    private int startIndex;
    private int endIndex;
    @Override
    public void run() {
        for(;startIndex <= endIndex; startIndex++) {
            int numOfMessage = startIndex + 1;
            System.out.println("Message " + numOfMessage + " was sent");
        }

    }

}
