package ru.kraiush.BJS2_37759;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SenderRunnable implements Runnable {
    private int startIndex;
    private int endIndex;
    @Override
    public void run() {
        for (int i = startIndex; i < endIndex; i++) {
            System.out.println("The email #" + i + " was sent");
        }
    }
}
