package ru.maks1979.task_48726;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class SenderRunnable implements Runnable {
    @Getter
    @Setter
    private int startIndex;
    @Getter
    @Setter
    private int endIndex;

    @Override
    public void run() {
        System.out.println("Письма с " + startIndex + "по " + endIndex + "отправлены");
    }
}