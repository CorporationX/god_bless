package bjs2_2853;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class SenderRunnable implements Runnable {
    private int startIndex;
    private int endIndex;
    
    @Override
    public void run() {
        System.out.printf("Успешное отправка пачек писем c %s по %s", startIndex, endIndex);
        System.out.println();
    }
}
