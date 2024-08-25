package work_in_microsoft;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class SenderRunnable implements Runnable{

    private int startIndex;
    private int endIndex;

    @Override
    public void run() {
        for (int i = startIndex; i <= endIndex; ++i) {
            System.out.printf("Отправлено письмо #%d%n", i);
        }
    }
}
