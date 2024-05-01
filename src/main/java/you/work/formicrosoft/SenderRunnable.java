package you.work.formicrosoft;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SenderRunnable implements Runnable {
    private int startIndex;
    private int endIndex;

    @Override
    public void run() {
        for (int i = this.startIndex; i <= this.endIndex; i++) {
            System.out.println("Письмо " + i + " успешно отправлено");
        }
    }
}
