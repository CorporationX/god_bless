package ru.maks1979.task_48726;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class SenderRunnable implements Runnable {
    @Setter
    private int startIndex;
    @Setter
    private int endIndex;

    public int getStartIndex(int startIndex) {
        return this.startIndex=startIndex;
    }

    public int getEndIndex(int endIndex) {
        return this.endIndex=endIndex;
    }

    @Override
    public void run() {
        System.out.println("Письма с " + startIndex + "по " + endIndex + "отправлены");
    }
}