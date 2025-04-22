package bjs2_72793;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SenderRunnable implements Runnable {
    private int startIndex;
    private int endIndex;

    public void run() {
        for(int i=startIndex; i<=endIndex; i++){
            System.out.println("The email has been sent " + i);
        }
    }
}
