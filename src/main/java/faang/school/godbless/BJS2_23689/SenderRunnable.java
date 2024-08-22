package faang.school.godbless.BJS2_23689;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SenderRunnable implements Runnable {

    private  int startIndex;
    private  int endIndex;

    @Override
    public void run() {
        System.out.println("письмо отправленно");
    }
}
