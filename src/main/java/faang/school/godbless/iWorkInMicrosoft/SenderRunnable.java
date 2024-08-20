package faang.school.godbless.iWorkInMicrosoft;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SenderRunnable implements Runnable{
    private int startIndex;
    private int endIndex;
    @Override
    public void run() {
        System.out.println("Mails " + startIndex + " - " + endIndex + " were send");
    }
}
