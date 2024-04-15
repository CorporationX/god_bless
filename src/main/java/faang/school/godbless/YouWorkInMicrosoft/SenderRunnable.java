package faang.school.godbless.YouWorkInMicrosoft;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SenderRunnable implements Runnable {
    private final int startIndex;
    private final int endIndex;

    @Override
    public void run() {
        for (int count = startIndex; count <= endIndex; count++) {
            System.out.println("Письмо " + count + " отправлено!");
        }
    }
}
