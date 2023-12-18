package faang.school.godbless.BJS2_994;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SenderRunnable implements Runnable{
    private int startIndex;
    private int endIndex;
    @Override
    public void run() {
        System.out.println("Successful sending an email");
    }
}
