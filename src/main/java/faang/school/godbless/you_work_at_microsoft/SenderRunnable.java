package faang.school.godbless.you_work_at_microsoft;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SenderRunnable implements Runnable{

    private int startIndex;
    private int endIndex;

    @Override
    public void run() {
        for (int i = startIndex; i <= endIndex; i++){
            System.out.println("Письм " + i + " отправлено.");
        }
    }
}
