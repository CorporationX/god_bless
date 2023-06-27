package faang.school.godbless.Sprint4.Microsoft;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SenderRunnable implements Runnable{
    private int startIndex;
    private int endIndex;

    @Override
    public void run() {
        while (startIndex < endIndex) {
            System.out.printf("Письмо номер: %d отправдено\n", startIndex+1);
            startIndex++;
        }
    }

}
