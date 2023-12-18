package faang.school.godbless.microsoft;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SenderRunnable implements Runnable {
    StackMail stackMail;

    @Override
    public void run() {
        System.out.printf("Emails from %d to %d were sent!", stackMail.getStartIndex(), stackMail.getEndIndex());
        System.out.println();
    }
}
