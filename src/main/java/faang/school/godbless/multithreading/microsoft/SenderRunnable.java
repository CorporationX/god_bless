package faang.school.godbless.multithreading.microsoft;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SenderRunnable implements Runnable{

    private int startIndex;
    private int endIndex;

    @Override
    public void run() {
        for (int i = startIndex; i <= endIndex; i++) {
            System.out.printf("[%s] send mail No: %04d\r\n",
                    Thread.currentThread().getName(), i);
        }
    }

}