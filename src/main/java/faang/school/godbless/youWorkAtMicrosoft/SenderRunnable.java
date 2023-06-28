package faang.school.godbless.youWorkAtMicrosoft;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SenderRunnable implements Runnable{
    private int startIndex;
    private int endIndex;

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            i++;
        }
        System.out.println("Сообщения в диапазоне: " + startIndex + " ... " + endIndex + " отправлены");
    }
}
