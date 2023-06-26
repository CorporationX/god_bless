package faang.school.godbless.IAmInMicrosoft;

import lombok.Data;
import lombok.NonNull;

public class SenderRunnable implements Runnable{
    private int startIndex;
    private int endIndex;

    public SenderRunnable(int startIndex, int endIndex) {
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    @Override
    public void run() {
        for (int i = startIndex; i <endIndex ; i++) {
            System.out.println("Сообщение успешно отправленно!");
        }

    }
}
