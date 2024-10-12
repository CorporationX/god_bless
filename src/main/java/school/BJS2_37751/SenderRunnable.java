package school.BJS2_37751;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SenderRunnable implements Runnable {

    private int startIndex;
    private int endIndex;

    @Override
    public void run() {
        while (startIndex <= endIndex) {
            System.out.printf("Письмо номер %d из потока %s отправлено", startIndex, Thread.currentThread().getName());
            System.out.println();
            startIndex++;
            if (startIndex > endIndex) {
                System.out.println(Thread.currentThread().getName() + ": закончил работу по отправке писем");
            }
        }
    }
}
