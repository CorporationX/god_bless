package school.faang.iworkinmicrosoft;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class SenderRunnable implements Runnable {

    private int startIndex;
    private int endIndex;
    private List<String> emails;

    @Override
    public void run() {
        for (int i = startIndex; i <= endIndex; i++) {
            System.out.println("Письмо отправлено" + emails.get(i) + Thread.currentThread().getName());
        }
    }
}
