package faang.school.godbless.workingInMicrosoft;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SenderRunnable implements Runnable {
    private int startIndex;
    private int endIndex;
    public void run() {
        for (int i = startIndex; i <= endIndex; i++) {
            System.out.println("Письмо успешно отправлено." + i);
        }
    }
}
