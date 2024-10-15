package org.example.model.microsoft;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SenderRunnable implements Runnable {
    private int startIndex;
    private int endIndex;

    @Override
    public void run() {
        for (int i = this.startIndex; i < endIndex; i++) {
            System.out.println(String.format("success sent %d!", i + 1));
        }
    }
}
