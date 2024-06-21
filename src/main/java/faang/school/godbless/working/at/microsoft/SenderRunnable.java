package faang.school.godbless.working.at.microsoft;

import java.util.List;

public class SenderRunnable implements Runnable{
    private List<String> mailsBlock;

    public SenderRunnable(List<String> mailsBlock) {
        this.mailsBlock = mailsBlock;
    }

    @Override
    public void run() {
        for (int i = 0; i < mailsBlock.size(); i++) {
            System.out.println("Mail: " + mailsBlock.get(i) + " was sent by " + Thread.currentThread().getName());
        }
    }
}
