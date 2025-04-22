package school.faang.bjs272783;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class SenderRunnable implements Runnable {
    private int startIndex;
    private int endIndex;

    @Override
    public void run() {
        for (int i = this.startIndex; i < this.endIndex; i++) {
            System.out.printf("Письмо %d отправлено (%s) %n ", i, Thread.currentThread().getName());
        }
    }
}
