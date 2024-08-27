package faang.school.godbless.BJS2_23689;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SenderRunnable implements Runnable {

    private int startIndex;
    private int endIndex;

    @Override
    public void run() {
        System.out.println("Запуск SenderRunnable: startIndex=" + startIndex + ", endIndex=" + endIndex);
        for (int j = startIndex; j < endIndex; j++) {
            System.out.println("письмо c индексом " + j + " отправленно");
        }
        System.out.println("Завершение SenderRunnable: startIndex=" + startIndex + ", endIndex=" + endIndex);
    }
}
