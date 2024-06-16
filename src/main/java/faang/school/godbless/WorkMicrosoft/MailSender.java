package faang.school.godbless.WorkMicrosoft;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class MailSender implements Runnable{
    private int startIndex;
    private int endIndex;
    @Override
    public void run() {
        for (int i = startIndex; i <= endIndex; i++) {
            System.out.println("Письмо " + i + " отправлено");
        }
    }
}
