package you_work_microsoft;

import lombok.Data;

@Data
public class SenderRunnable implements Runnable {
    private int startIndex;
    private int endIndex;

    public SenderRunnable(int startIndex, int endIndex) {
        this.endIndex = endIndex;
        this.startIndex = startIndex;
    }

    @Override
    public void run() {
        System.out.println("Поток начал работу!");
        for (int i = startIndex = 0; i < endIndex; i++) {
            System.out.println("Письмо отправлено" + i);
        }
        System.out.println("Поток закончил работу!");
    }
}
