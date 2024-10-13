package bjs2_35730;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SenderRunnable implements Runnable {
    int startIndex;
    int endIndex;

    @Override
    public void run() {
        for (int i = startIndex; i <= endIndex; i++) {
            System.out.println("Mail was successfully sent!");
        }
    }
}
