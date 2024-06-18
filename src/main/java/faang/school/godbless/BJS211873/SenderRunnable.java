package faang.school.godbless.BJS211873;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SenderRunnable implements Runnable {

    private int startIndex;
    private int endIndex;

    @Override
    public void run() {
        for (int i = startIndex; i <= endIndex; i++) {
            System.out.println("Поток " + Thread.currentThread().getName() + " отправил письмо " + i);
        }
    }
}
