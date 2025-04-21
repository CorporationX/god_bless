package school.faang.microsoft;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SenderRunnable implements Runnable {

    private final int startIndex;

    private final int endIndex;

    @Override
    public void run() {
        for (int i = startIndex; i < endIndex; i++) {
            System.out.printf("Письмо под номером %d отправлено", i);
        }
    }
}
