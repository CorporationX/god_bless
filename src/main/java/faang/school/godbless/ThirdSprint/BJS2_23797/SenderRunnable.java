package faang.school.godbless.ThirdSprint.BJS2_23797;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SenderRunnable implements Runnable {

    private int startIndex;
    private int endIndex;

    @Override
    public void run() {
        for (int i = startIndex; i <= endIndex; i++) {
            System.out.println("Письмо номер: " + i + " отправлено!");
        }
    }
}
