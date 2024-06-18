package faang.school.godbless.microsoft;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;

@Data
@AllArgsConstructor
public class SenderRunnable implements Runnable {
    private int startIndex;
    private int endIndex;
    public static void  sendMail(ArrayList<String> mailsPool) {
        mailsPool.forEach(string -> System.out.println("Письмо %s было успешно отправлено!"));
    }

    @Override
    public void run() {
//SenderRunnable.sendMail(); - stoping
    }
}
