package school.faang.bjs2_89585;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class SenderRunnable implements Runnable {
    private int startIndex;
    private int endIndex;

    @Override
    public void run() {
        for (int letter = startIndex; letter < endIndex; letter++) {
            System.out.printf("Отправлено письмо № %d%n", letter);
        }
    }
}
